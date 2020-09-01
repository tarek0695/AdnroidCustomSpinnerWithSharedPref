package com.pixelhubllc.customspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {
    Context context;
    int flags[];
    String[] countryNames;
    LayoutInflater inflter;

//    public CustomAdapter(Context applicationContext, int[] flags, String[] countryNames) {
//        this.context = applicationContext;
//        this.flags = flags;
//        this.countryNames = countryNames;
//        inflter = (LayoutInflater.from(applicationContext));
//    }

    public CustomAdapter(Context applicationContext, int[] flags) {
        this.context = applicationContext;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }


    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_spinner_items, null);
       TextView icon = (TextView) view.findViewById(R.id.imageView);
//        TextView names = (TextView) view.findViewById(R.id.textView);
       icon.setText(String.valueOf(flags[i]));
//        names.setText(flags[i]);
        return view;
    }
}
