package com.example.comp.linearequationsolver.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by COMP on 26.5.2018..
 */

public class BaseActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();

    protected void addFragment(int fragmentContainer, Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainer, fragment);

        fragmentTransaction.commit();
    }

    protected void replaceFragment(int fragmentContainer, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainer, fragment);

        if(addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }
}
