package com.pixelhubllc.customspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    SharedPref sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        sharedPref = new SharedPref(getApplicationContext());
        int num = sharedPref.loadSpinnerPosValue();
        Log.e("TAG", "onCreate: " + num );

        TextView textView = findViewById(R.id.text_view);

        textView.setText(String.valueOf(num));
    }
}
