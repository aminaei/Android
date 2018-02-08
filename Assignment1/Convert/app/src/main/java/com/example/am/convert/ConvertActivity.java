///////////////////////////////////////////////////////////////////////////////
// Class:            CS 646 Android Mobile Application Development
// Title:            Assignment 1 -- Convert
// Date :             Jan 28, 2018
// Date :             Jan 28, 2018
//
// Files:            ConvertActivity.java
// Semester:         Spring Semester, 2018
//
// Author:           Ali Minaei
// Email:            aminaei@sdsu.edu
//
//////////////////////// Objectives //////////////////////////////////////////
//
// 1. Learn how to use Android Studio to create an Android app
// 2. Use basic GUI widgets
// 3. Handle Screen rotation
//
////////////////////////////// Notes ///////////////////////////////////////////
// Double Click to Clear the Field!!!!
//
///////////////////////////////////////////////////////////////////////////////

package com.example.am.convert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ConvertActivity extends AppCompatActivity {

    private Button convertBotton;
    private EditText usdTextViewInput;
    private EditText inrTextViewInput;

    private Convert mConvert = new Convert(0,0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);


       usdTextViewInput = (EditText) findViewById(R.id.usd_amount_textView);
       inrTextViewInput = (EditText) findViewById(R.id.inr_amount_textView);

        inrTextViewInput.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View v) {
                mConvert.setUsdValueId(0.0);
                inrTextViewInput.setText("");
                usdTextViewInput.setText("");

            }
        });

        usdTextViewInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mConvert.setInrValueId(0.0);
                usdTextViewInput.setText("");
                inrTextViewInput.setText("");
            }
        });

        convertBotton = (Button) findViewById(R.id.covert_button);
        convertBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkIfFieldEmpty(usdTextViewInput)){
                   double usdAmount =  Double.parseDouble(usdTextViewInput.getText().toString());
                   // Log.i("-->EditorAction","USD Value = "+Double.toString(usdAmount));
                   mConvert.setInrValueId(usdAmount);
                   double inrValue = mConvert.getInrValueId();
                   String inrValueStr = String.format("%.2f",inrValue);

                   inrTextViewInput.setText(inrValueStr);
                }
                else if(checkIfFieldEmpty(inrTextViewInput)){
                    double inrAmount =  Double.parseDouble(inrTextViewInput.getText().toString());
                    // Log.i("-->EditorAction","IRN Value = "+Double.toString(inrAmount));
                    mConvert.setUsdValueId(inrAmount);

                    double usdValue = mConvert.getUsdValueId();
                    String usdValueStr = String.format("%.2f",usdValue);

                    usdTextViewInput.setText(usdValueStr);
                }

                // Toast.makeText(ConvertActivity.this,usdReturnStr,Toast.LENGTH_LONG).show();
            }
        });


    }
    public boolean checkIfFieldEmpty(EditText checkContent){
        if(checkContent.getText().toString().equals("")){
            return false;
        }
        return true;
    }
}
