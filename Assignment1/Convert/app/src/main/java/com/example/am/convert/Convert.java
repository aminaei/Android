///////////////////////////////////////////////////////////////////////////////
// Class:            CS 646 Android Mobile Application Development
// Title:            Assignment 1 -- Convert
// Date :             Jan 28, 2018
//
// Files:            Convert.java
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
///////////////////////////////////////////////////////////////////////////////
package com.example.am.convert;


import android.util.Log;

public class Convert {
    private double usdValueId;
    private double inrValueId;

    public Convert(double usdValue, double inrValue){
        usdValueId = usdValue;
        inrValueId = inrValue;
    }

    public double getUsdValueId() {
        return usdValueId;
    }

    public void setUsdValueId(double inrValueId) {
        this.usdValueId = inrValueId*63.89;
    }

    public double getInrValueId() {
        return inrValueId;
    }

    public void setInrValueId(double usdValueId) {
        this.inrValueId = usdValueId*0.016;

        // Log.i("myTag","IRN Value = "+Double.toString(inrValueId));
    }
}

