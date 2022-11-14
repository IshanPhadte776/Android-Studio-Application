package com.example.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomBaseAdapterClass extends BaseAdapter {

    Context context;
    ArrayList<Complaint> listOfComplaints;

    LayoutInflater inflater;
    //All this code is need for the admin to see a list of complaints on his screen
    public CustomBaseAdapterClass(Context ctx, ArrayList<Complaint> complaintArrayList) {
        inflater = LayoutInflater.from(ctx);
        this.context = ctx;
        this.listOfComplaints = complaintArrayList;

    }

    @Override
    public int getCount() {
        return listOfComplaints.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= inflater.inflate(R.layout.activity_custom_list_view_complaints_class_complaint,null);



        return convertView;
    }
}