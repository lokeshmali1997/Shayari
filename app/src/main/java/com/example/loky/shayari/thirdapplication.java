package com.example.loky.shayari;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class thirdapplication extends AppCompatActivity {

    TextView txt;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdapplication);


        getSupportActionBar().setDisplayShowCustomEnabled(true);

        txt = (TextView) findViewById(R.id.txtvw2);
        Intent intent = getIntent();
        str = intent.getStringExtra("quotes").toString();

        txt.setText(str);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);

            sharingIntent.setType("text/plain");
//            sharingIntent.setPackage("com.whatsapp");


            sharingIntent.putExtra(Intent.EXTRA_TEXT,str);

        try{
          startActivity(Intent.createChooser(sharingIntent, "Share using"));

//            startActivity(sharingIntent);


        }catch (android.content.ActivityNotFoundException ex){

            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        }



        return super.onOptionsItemSelected(item);


    }


}
