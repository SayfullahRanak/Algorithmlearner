package com.example.ranak.algorithmlearner;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;


public class StartPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        Button sort=(Button)findViewById(R.id.button4);
        Button stack=(Button)findViewById(R.id.button6);
        Button queue=(Button)findViewById(R.id.button7);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntant=new Intent();
                myIntant.setClass(getBaseContext(),MainActivity.class);
                startActivity(myIntant);
            }
        });
        stack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntant=new Intent();
                myIntant.putExtra("type","stack");
                myIntant.setClass(getBaseContext(),stack.class);
                startActivity(myIntant);

            }
        });
        queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntant=new Intent();
                myIntant.putExtra("type","queue");
                myIntant.setClass(getBaseContext(),stack.class);
                startActivity(myIntant);

            }
        });
    }



}
