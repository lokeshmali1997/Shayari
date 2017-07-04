package com.example.loky.shayari;

import static android.R.attr.id;

/**
 * Created by Loky on 6/16/2017.
 */

public class Post {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int id;
    public String name;
}
