package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (findViewById(R.id.verticalLayout) != null) {
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .hide(fragmentManager.findFragmentById(R.id.verticalConceptFragment))
                    .commit();
        }

    }
}