package com.example.loky.shayari;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Loky on 6/15/2017.
 */

public class Customlistview extends BaseAdapter {

    ListViewlist listViewlist;
    int customlistview;
    ArrayList<Qlist> qlist;

    public Customlistview(ListViewlist listViewlist, int customlistview , ArrayList<Qlist> qlist  ){

        this.listViewlist = listViewlist;
        this.qlist = qlist;
        this.customlistview = customlistview;


    }



    @Override
    public int getCount() {
        return qlist.size();
    }

    @Override
    public Object getItem(int position) {
        return qlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {


        view = LayoutInflater.from(listViewlist).inflate(R.layout.customlistview,parent,false);

     TextView tv = (TextView)view.findViewById(R.id.listext);

        tv.setText(qlist.get(position).getQuotes());
//        ImageView iv = (ImageView)view.findViewById(R.id.img);


//        iv.setImageResource(img[i]);





        return view;
    }
}
