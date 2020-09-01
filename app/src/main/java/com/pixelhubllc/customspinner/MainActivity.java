package com.pixelhubllc.customspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    SharedPreferences lastSelect;
    SharedPreferences.Editor editor;

    String[] countryNames={"India","China","Australia","Portugle","America","New Zealand"};
    //int flags[] = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    int flags[] = {1,2,4,5};

//    ArrayList<Integer> nums = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        nums.add(5);
//        nums.add(10);
//        nums.add(15);
//        nums.add(25);
//        nums.add(50);

        lastSelect = getSharedPreferences("lastSetting", Context.MODE_PRIVATE);
        editor = lastSelect.edit();

        final int lastClick = lastSelect.getInt("lastClick", 0);
        Log.e("lastClick", "onItemSelected: " + lastClick );

        Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);


//        spin.setOnItemSelectedListener(this);

       // CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),flags,countryNames);
        CustomAdapter customAdapter=new CustomAdapter(MainActivity.this,flags);
        spin.setAdapter(customAdapter);
        spin.setSelection(lastClick);

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        editor.putInt("lastClick", position).commit();
       Log.e("lastClick", "lastSelect: " + position );

        Toast.makeText(getApplicationContext(), String.valueOf(flags[position]), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


}
