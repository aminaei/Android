///////////////////////////////////////////////////////////////////////////////
// Class:            CS 646 Android Mobile Application Development
// Title:            Assignment 2 -- Convert
// Date :             Feb 11, 2018
//
// Files:            MajorActivity.java
// Semester:         Spring Semester, 2018
//
// Author:           Ali Minaei
// Email:            aminaei@sdsu.edu
//
/////////////////////////////////////////////////////////////////////////////

package com.example.am.assignment2;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MajorActivity extends AppCompatActivity implements  DegreesFragment.DegreeListener, MajorFragment.MajorListener{
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major);


//        MajorFragment fragment = new MajorFragment();
        fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = new DegreesFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit();


        }



    }

    public void phdSelected(View v){
        degreeSelected("Ph.D.");
    }
    public void eddSelected(View v){
        degreeSelected("Ed.D.");
    }
    public void maSelected(View v){
        degreeSelected("MA");
    }
    public void msSelected(View v){
        degreeSelected("MS");
    }
    public void mfaSelected(View v){
        degreeSelected("MFA");
    }
    public void pmdSelected(View v){
        degreeSelected("PMD");
    }


    @Override
    public void degreeSelected(String degreeName) {
        //Log.v(">> in degreeSelected ","I'm Here ");
        Bundle degreeBundle = new Bundle();
        degreeBundle.putString("degrees",degreeName);

        MajorFragment fragment = new MajorFragment();
        fragment.setArguments(degreeBundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void majorSelected(String majorName) {
        // Log.v("->-> in majorSelected ", majorName);

        Intent toPassBack = getIntent();
        toPassBack.putExtra("major", majorName);
        setResult(RESULT_OK,toPassBack);
        finish();

    }
}
