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
    int nums[];
    LayoutInflater inflter;


    public CustomAdapter(Context applicationContext, int[] nums) {
        this.context = applicationContext;
        this.nums = nums;
        inflter = (LayoutInflater.from(applicationContext));
    }


    @Override
    public int getCount() {
        return nums.length;
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
       icon.setText(String.valueOf(nums[i]));
        return view;
    }
}
