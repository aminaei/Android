///////////////////////////////////////////////////////////////////////////////
// Class:            CS 646 Android Mobile Application Development
// Title:            Assignment 2 -- Convert
// Date :             Feb 11, 2018
//
// Files:            DegreesFragment.java
// Semester:         Spring Semester, 2018
//
// Author:           Ali Minaei
// Email:            aminaei@sdsu.edu
//
/////////////////////////////////////////////////////////////////////////////
package com.example.am.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class DegreesFragment extends Fragment{

    //private Button phdButton;
    private Button eddButton;
    private Button maButton;
    private Button msdButton;
    private Button mfaButton;
    private Button pmdButton;

    private View view;
    private DegreeListener listener;


    public DegreesFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){

        super.onActivityCreated(savedInstanceState);
        listener = (DegreeListener) getActivity();

        view = inflater.inflate(R.layout.fragment_major, container, false);


        return view;

    }

    public interface DegreeListener {
        public void degreeSelected (String degreeName);
    }
}

