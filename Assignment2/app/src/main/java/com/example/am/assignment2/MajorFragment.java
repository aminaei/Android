///////////////////////////////////////////////////////////////////////////////
// Class:            CS 646 Android Mobile Application Development
// Title:            Assignment 2 -- Convert
// Date :             Feb 11, 2018
//
// Files:            MajorFragment.java
// Semester:         Spring Semester, 2018
//
// Author:           Ali Minaei
// Email:            aminaei@sdsu.edu
//
/////////////////////////////////////////////////////////////////////////////
package com.example.am.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;



public class MajorFragment extends Fragment {

    private Button cancelButton;

    private View view;
//    private static final int RESULT_OK =750;


    public MajorFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){

        super.onActivityCreated(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_list, container, false);

        cancelButton = (Button) view.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new Button.OnClickListener(){
         @Override
         public void onClick(View v) {
             FragmentManager fragmentManager = getFragmentManager();
             fragmentManager.popBackStack();

         }
        });



//                Intent in=new Intent(getActivity(),MajorActivity.class);
//                in.putExtra("degrees","Ph.D.");
//                startActivity(in);
        final Bundle degreeBundle = this.getArguments();


        ListView majorListView = (ListView) view.findViewById(R.id.major_list);


        if(degreeBundle != null) {
            String degreeValue = degreeBundle.getString("degrees");
            if (degreeValue.equals("Ph.D.")) {
                ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.phd_list, android.R.layout.simple_list_item_1);
                majorListView.setAdapter(adapter);
            }
            if (degreeValue.equals("Ed.D.")) {
                ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.edd_list, android.R.layout.simple_list_item_1);
                majorListView.setAdapter(adapter);
            }
            if (degreeValue.equals("MA")) {
                ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.ma_list, android.R.layout.simple_list_item_1);
                majorListView.setAdapter(adapter);
            }
            if (degreeValue.equals("MS")) {
                ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.ms_list, android.R.layout.simple_list_item_1);
                majorListView.setAdapter(adapter);
            }
            if (degreeValue.equals("MFA")) {
                ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.mfa_list, android.R.layout.simple_list_item_1);
                majorListView.setAdapter(adapter);
            }
            if (degreeValue.equals("PMD")) {
                ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.pmd_list, android.R.layout.simple_list_item_1);
                majorListView.setAdapter(adapter);
            }


            majorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String majorInfo = ((TextView) view).getText().toString();
                String degreeValue = degreeBundle.getString("degrees");
                // Log.v("----> Major = ",degreeValue+" "+majorInfo);

                    // degreeBundle.putString("degrees","Ph.D.");
                    MajorListener listener = (MajorListener) getActivity();


                if(degreeValue.equals("PMD")) {
                    listener.majorSelected(majorInfo);
                }
                else{
                    listener.majorSelected(degreeValue+" "+majorInfo);

                }
                }
            });

        }

        return view;

    }
    public interface MajorListener {
        public void majorSelected (String majorName);
    }


}
