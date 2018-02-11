package com.example.ranak.algorithmlearner;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class stack extends ActionBarActivity {
    private int _intMyLineCount=0;


    private List<Button> ButtonList = new ArrayList<Button>();
    StackOfObjects stackz = new StackOfObjects();
    Queue<Button> q = new LinkedList<Button>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);
        final String type=getIntent().getExtras().getString("type");
        final EditText editText=(EditText)findViewById(R.id.stackinput);
        final Button command=new Button(this);
        final LinearLayout LLmn=(LinearLayout) findViewById(R.id.StackLayout);

        Button push=(Button)findViewById(R.id.button9);
        Button pop=(Button)findViewById(R.id.button10);

        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().trim().length()>0)
                {
                    final int input= Integer.parseInt(editText.getText().toString());
                    editText.setText(null);

                    LLmn.addView(push(input,type));
                }

            }
        });
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(type.equals("stack"))
                {
                    Button s= (Button) stackz.pop();

                    s.setVisibility(View.GONE);

                }
                else if(type.equals("queue")) {
                    Button s = (Button) q.poll();
                    s.setVisibility(View.GONE);
                }



            }
        });


    }
    private Button push(int Id,String type)
    {
        Button pushButton=new Button(this);
        pushButton.setId(Id);
        pushButton.setText("" + Id);
        pushButton.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.weight=0.5f;
        if(type.equals("stack"))
        {
            stackz.push(pushButton);
        }
        else if(type.equals("queue"))
        {
            q.add(pushButton);
        }



        return pushButton;
    }

}
