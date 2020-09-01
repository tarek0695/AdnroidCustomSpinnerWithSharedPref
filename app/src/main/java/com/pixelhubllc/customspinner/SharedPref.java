package com.pixelhubllc.customspinner;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    SharedPreferences mSharedPref;

    public SharedPref(Context context){
        mSharedPref = context.getSharedPreferences("filename",Context.MODE_PRIVATE);
    }

    //this method will save night mode state , true or false
    public void setSpinnerValue(int value){
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putInt("SpinnerValue", value);
        editor.commit();
    }

    //this method will load the night mode state
    public int loadSpinnerValue(){
        int value = mSharedPref.getInt("SpinnerValue", 0);
        return value;
    }


}
