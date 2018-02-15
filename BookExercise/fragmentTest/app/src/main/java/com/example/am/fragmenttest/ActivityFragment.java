package com.example.am.fragmenttest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by am on 2/11/18.
 */

public class ActivityFragment extends Fragment{

    private Button phdButton;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_test, container, false);

//        phdButton = (Button) view.findViewById(R.id.phd_button);
//
//        phdButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//
//                Fragment fragment = ;
//
//                ActivityFragment fragment = new ActivityFragment();
//                fm.beginTransaction().add(R.id.fragment, fragment).commit();
//            }
//        });

        ListView mainListView = (ListView) view.findViewById(R.id.phd_list);

        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.PHD, android.R.layout.simple_list_item_1);

        mainListView.setAdapter(adapter);
        return view;
    }


//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
//                R.array.PHD, android.R.layout.simple_list_item_1);
//        setListAdapter(adapter);
//        getListView().setOnItemClickListener(this);
//    }
//
//
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
//    }
}
