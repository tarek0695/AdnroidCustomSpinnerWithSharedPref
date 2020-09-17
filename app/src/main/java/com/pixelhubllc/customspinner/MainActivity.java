package com.pixelhubllc.customspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    //SharedPreferences lastSelect;
   // SharedPreferences.Editor editor;
    int nums[] = {1,2,4,5};
    SharedPref sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPref = new SharedPref(getApplicationContext());

        //lastSelect = getSharedPreferences("lastSetting", Context.MODE_PRIVATE);
      //  editor = lastSelect.edit();

     //   final int lastClick = lastSelect.getInt("lastClick", 0);
        int lastClick = sharedPref.loadSpinnerValue();
        Log.e("lastClick", "onItemSelected: " + lastClick );

        final Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);

        CustomAdapter customAdapter=new CustomAdapter(MainActivity.this,nums);
        spin.setAdapter(customAdapter);
        spin.setSelection(lastClick);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //editor.putInt("lastClick", position).commit();
                sharedPref.setSpinnerValue(position);
                sharedPref.setSpinnerPosValue(nums[position]);
                Log.e("lastClick", "lastSelect: " + position );
                Toast.makeText(getApplicationContext(), String.valueOf(nums[position]), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(intent);
            }
        });

    }

}
