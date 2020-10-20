package com.example.fragment.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fragment.R;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Map<String, String> concepts = new HashMap<String, String>();
    private ListView conceptsList;
    private TextView conceptTxt;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        concepts.put("Android", "Android is a mobile operating system based on a modified version of the Linux kernel and other open " +
                "source software, designed primarily for touchscreen mobile devices such as smartphones and tablets.");

        concepts.put("Activity", "An Activity is an application component that provides a screen with which users can interact in order to do something");

        concepts.put("Layout", "A layout defines the structure for a user interface in your app, such as in an activity.");

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        conceptsList = getView().findViewById(R.id.conceptsList);

        conceptsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String term = (String) parent.getItemAtPosition(position);
                String concept = concepts.get(term);

                Bundle bundle = new Bundle();
                bundle.putString("concept", concept);

                ConceptFragment conceptFragment = new ConceptFragment();
                conceptFragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                int orientation = getResources().getConfiguration().orientation;

                if( orientation == Configuration.ORIENTATION_LANDSCAPE ) {
                    fragmentTransaction.replace(R.id.landscapeConceptFragment, conceptFragment )
                            .addToBackStack(null)
                            .commit();
                }
                else {
                    fragmentTransaction.replace(R.id.verticalConceptFragment, conceptFragment )
                            .hide(fragmentManager.findFragmentById(R.id.verticalListFragment))
                            .show(fragmentManager.findFragmentById(R.id.verticalConceptFragment))
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }
}

/* String term = (String) parent.getItemAtPosition(position);
                String concept = concepts.get(term.toLowerCase());

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Bundle bundle = new Bundle();
                bundle.putString("concept", concept);

                ConceptFragment conceptFragment = new ConceptFragment();
                conceptFragment.setArguments(bundle);

                getFragmentManager().beginTransaction().add(R.id.container, fragment).commit();

                int orientation = getResources().getConfiguration().orientation;

                if( orientation == Configuration.ORIENTATION_LANDSCAPE )
                    fragmentTransaction.replace(R.id., conceptFragment );*/