package com.example.loky.shayari;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class shayari2 extends AppCompatActivity {

    GridView gridview;

    int[] img = new int[]{R.drawable.happy, R.drawable.sad, R.drawable.funny, R.drawable.friendship,
            R.drawable.brithday, R.drawable.romantic,R.drawable.motivational};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayari2);

        gridview = (GridView)findViewById(R.id.gridview);

//        String[] as = getResources().getStringArray(R.array.str);
//        ArrayAdapter <String> adapter = new ArrayAdapter<String>(shayari2.this,android.R.layout.simple_list_item_1,as);

        new Gridclass().execute("http://rapidans.esy.es/test/getallcat.php");


    }

    class Gridclass extends AsyncTask<String, Void, String> {

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(shayari2.this);
            dialog.setMessage("Loading....");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            HttpURLConnection connection;
            try {
                URL url = new URL(params[0]);
                try {
                    connection = (HttpURLConnection) url.openConnection();
                    connection.connect();

                    InputStream stream = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

                    StringBuffer buffer = new StringBuffer();
                    String line = "";

                    while ((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }

                    String bufferString = buffer.toString();
                    return bufferString;

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            ArrayList<Post> postArrayList = new ArrayList<>();
//            ArrayList<categories> cats = new ArrayList<>();
            try {
                JSONObject obj1 = new JSONObject(s);
                JSONArray jsonarray = obj1.getJSONArray("data");
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject obj2 = jsonarray.getJSONObject(i);

                    int id = obj2.getInt("id");
                    String name = obj2.getString("name");

                    Post post = new Post();
                    post.setId(id);
                    post.setName(name);
                    postArrayList.add(post);
                }


            } catch (JSONException e1) {
                e1.printStackTrace();
            }

            CustomGridview adapter1 = new CustomGridview(shayari2.this,R.layout.gridview, postArrayList,img);
            gridview.setAdapter(adapter1);

            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    Intent intent = new Intent(shayari2.this,ListViewlist.class);
                    intent.putExtra("lk",position);
                    startActivity(intent);
                }
            });

        }
    }
}
