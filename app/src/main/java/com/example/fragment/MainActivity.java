package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .hide(fragmentManager.findFragmentById(R.id.verticalConceptFragment))
                    .show(fragmentManager.findFragmentById(R.id.landscapeConceptFragment))
                    .commit();
        }

    }
}