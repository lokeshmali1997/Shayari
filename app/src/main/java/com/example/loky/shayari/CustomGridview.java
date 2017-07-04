package com.example.loky.shayari;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Loky on 6/14/2017.
 */

public class CustomGridview extends BaseAdapter {

    Context context;
    ArrayList<Post> posts;
    int[] img;
    int gridview;


    public CustomGridview(Context context, int gridview, ArrayList<Post> posts, int[] img) {
        this.context = context;
        this.posts = posts;
        this.img = img;
        this.gridview = gridview;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        view = LayoutInflater.from(context).inflate(R.layout.gridview,parent,false);

        ImageView imgv = (ImageView)view.findViewById(R.id.imgg);
        TextView txt = (TextView)view.findViewById(R.id.txtvw1);

        txt.setText(posts.get(position).getName());
        imgv.setImageResource(img[position]);


        return view;
    }

}


