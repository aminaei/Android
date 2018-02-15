///////////////////////////////////////////////////////////////////////////////
// Class:            CS 646 Android Mobile Application Development
// Title:            Assignment 2 -- Convert
// Date :             Feb 11, 2018
//
// Files:            MainActivity.java
// Semester:         Spring Semester, 2018
//
// Author:           Ali Minaei
// Email:            aminaei@sdsu.edu
//
//////////////////////// Objectives //////////////////////////////////////////
//
// 1. Use some basic UI widgets
// 2. Use Intents to call other Activities
// 3. Handling the Keyboard
// 4. Using Fragments
// 5. Permanent storage
//
///////////////////////////////////////////////////////////////////////////////

package com.example.am.assignment2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {

    private EditText fnameTextView;
    private EditText lnameTextView;
    private EditText ageTextView;
    private EditText emailTextView;
    private EditText phoneTextView;
    private EditText majorTextView;
    private Button doneButton;
    private final static String DATA_FILE="data_storetext.txt";
    private static final int INTENT_DEGREE_REQUEST = 783;
    static final int READ_BLOCK_SIZE = 100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fnameTextView = (EditText) findViewById(R.id.fnameText);
        lnameTextView = (EditText) findViewById(R.id.lnameText);
        ageTextView   = (EditText) findViewById(R.id.ageText);
        emailTextView = (EditText) findViewById(R.id.emailText);
        phoneTextView = (EditText) findViewById(R.id.phoneText);
        majorTextView = (EditText) findViewById(R.id.majorText);


        if(fileExist(DATA_FILE)){
            readFileInEditor();
        }


    }
    public void goToMajorActivity(View button) {
        Intent goToMajorActivityIntent = new Intent(this,MajorActivity.class);
        startActivityForResult (goToMajorActivityIntent, INTENT_DEGREE_REQUEST);
    }

    public void clearPersonalInfo(View view){
        fnameTextView.setText("");
        lnameTextView.setText("");
        ageTextView.setText("");
        emailTextView.setText("");
        phoneTextView.setText("");
        majorTextView.setText("");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to

            if (resultCode != RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.
                Log.v(">>>>>> ","RESULT_OK Failed <<<<<<<<<");
                return;
                // Do something with the contact here (bigger example below)
            }
        if (requestCode == INTENT_DEGREE_REQUEST) {
                if(data==null){
                    return;
                }
            final String majorValue = data.getExtras().getString("major");
            //Log.v(">>>>  onActivityResult ",""+majorValue);

            majorTextView.setText(majorValue);

        }

    }


    public void saveClicked(View v) {
        String filename = DATA_FILE;

         String fnameText = fnameTextView.getText().toString()+";";
         String lnameText = lnameTextView.getText().toString()+";";
         String ageText   = ageTextView.getText().toString()+";";
        String emailText  = emailTextView.getText().toString()+";";
        String phoneText  = phoneTextView.getText().toString()+";";
        String majorText  = majorTextView.getText().toString()+";";
        FileOutputStream outputStream;


        if(fileExist(filename)){
            Log.v("--> myfile.txt ","EXIST");
            deleteFile(filename);
        }
        /*
        File file = new File(this.getFilesDir()<location>, name)
        BufferedFileWriter buffered = new BufferedWriter(new FileWriter(file, append:false))
         */

        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
              outputStream.write(fnameText.getBytes());
              outputStream.write(lnameText.getBytes());
              outputStream.write(ageText.getBytes());
              outputStream.write(emailText.getBytes());
              outputStream.write(phoneText.getBytes());
              outputStream.write(majorText.getBytes());
              outputStream.close();
            Log.v("--> From saveClicked: ",majorTextView.getText().toString());

            Toast.makeText(this,"The contents are saved in the file.",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public boolean fileExist(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }
    

    public void readFileInEditor(){
        try {
            FileInputStream fileInput=openFileInput(DATA_FILE);
            InputStreamReader InputRead= new InputStreamReader(fileInput);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String dataString="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                dataString +=readstring;
            }
            InputRead.close();
            String[] dataStringArray = dataString.split(";");
            fnameTextView.setText(dataStringArray[0]);
            lnameTextView.setText(dataStringArray[1]);
            ageTextView.setText(dataStringArray[2]);
            emailTextView.setText(dataStringArray[3]);
            phoneTextView.setText(dataStringArray[4]);
            majorTextView.setText(dataStringArray[5]);
            //Toast.makeText(getBaseContext(), dataString,Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
