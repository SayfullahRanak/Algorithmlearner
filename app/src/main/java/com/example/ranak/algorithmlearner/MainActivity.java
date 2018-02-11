package com.example.ranak.algorithmlearner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.LinearLayout.VERTICAL;


public class MainActivity extends Activity {

    private Button btnMyLine,btnSent;
    private LinearLayout LLEnterText;
    private int _intMyLineCount;

    private List<EditText> editTextList = new ArrayList<EditText>();
    private List<TextView> textviewList=new ArrayList<TextView>();
    private List<LinearLayout> linearlayoutList=new ArrayList<LinearLayout>();
    int[] data;
    int numberOfinput=0;
    int arraylength=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText text = (EditText) findViewById(R.id.edittext);
        LLEnterText=(LinearLayout) findViewById(R.id.FirstLayout);
        final TextView textview=(TextView)findViewById(R.id.textview);

        //LLEnterText.setOrientation(LinearLayout.VERTICAL);
        btnMyLine=(Button) findViewById(R.id.button1);
        btnSent=(Button) findViewById(R.id.button2);
        Button btnBubble=(Button) findViewById(R.id.button3);


        btnMyLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString().trim().length()>0)
                {
                    numberOfinput = Integer.parseInt(text.getText().toString());
                    data=new int[numberOfinput];
                    LLEnterText.addView(txtView2());
                    for(int i=1;i<=numberOfinput;i++)
                    {
                        LLEnterText.addView(linearlayout(_intMyLineCount));
                        _intMyLineCount++;
                    }
                    btnMyLine.setEnabled(false);
                    btnMyLine.setVisibility(View.INVISIBLE);
                    text.setText(null);
                }

                //btnMyLine.isEnabled();

            }
        });
        btnSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] strings=new String[editTextList.size()];
                Intent myIntant=new Intent();
                myIntant.putExtra("arraylength",""+editTextList.size());
                myIntant.putExtra("Sort type","Insertion");
                for(int i=0;i<editTextList.size();i++)
                {
                    myIntant.putExtra(""+i,Integer.parseInt(editTextList.get(i).getText().toString()));
                    //data[i]=Integer.parseInt(LLEnterText);
                }
                myIntant.setClass(getBaseContext(),simulation.class);
                startActivity(myIntant);

            }
        });
        btnBubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings=new String[editTextList.size()];
                Intent myIntant=new Intent();
                myIntant.putExtra("arraylength",""+editTextList.size());

                for(int i=0;i<editTextList.size();i++)
                {
                    myIntant.putExtra(""+i,Integer.parseInt(editTextList.get(i).getText().toString()));
                    //data[i]=Integer.parseInt(LLEnterText);
                }
                myIntant.putExtra("Sort type","Bubble");
                myIntant.setClass(getBaseContext(),simulation.class);
                startActivity(myIntant);

            }
        });



    }

    private EditText editText(int _intID) {
        EditText editText = new EditText(this);
        editText.setId(_intID);
        //editText.setWidth(60);
        editText.setBackgroundColor(Color.GRAY);
        //editText.setInputType();
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        editText.setLayoutParams(lp);
        lp.weight=1.5f;
        editTextList.add(editText);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        return editText;
    }
    private TextView textView(int _intID)
    {
        TextView txtviewAll=new TextView(this);
        //txtviewAll.setWidth();
        txtviewAll.setId(_intID);
        txtviewAll.setText(""+_intID);
        txtviewAll.setTextColor(Color.BLACK);
        txtviewAll.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.weight=0.5f;
        txtviewAll.setLayoutParams(lp);
        //txtviewAll.getCompoundPaddingBottom()
        textviewList.add(txtviewAll);
        return txtviewAll;
    }
    private LinearLayout linearlayout(int _intID)
    {
        LinearLayout LLMain=new LinearLayout(this);
        LLMain.setWeightSum(2);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0,0,0,20);
        LLMain.setLayoutParams(lp);
        LLMain.setId(_intID);
        LLMain.addView(textView(_intID));
        LLMain.addView(editText(_intID));

        LLMain.setOrientation(LinearLayout.HORIZONTAL);
        linearlayoutList.add(LLMain);
        return LLMain;

    }
    private LinearLayout txtView2()
    {
        TextView txtviewAll=new TextView(this);
        LinearLayout LLMain=new LinearLayout(this);
        LLMain.setWeightSum(2);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0,0,0,20);
        LLMain.setLayoutParams(lp);

        LLMain.setOrientation(LinearLayout.HORIZONTAL);

        //txtviewAll.setWidth();

        txtviewAll.setText("Input Nmbers(array)");
        txtviewAll.setTextColor(Color.BLACK);
        txtviewAll.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams lps=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lps.weight=0.5f;
        txtviewAll.setLayoutParams(lps);

        LLMain.addView(txtviewAll);

        TextView txtsviewAll=new TextView(this);

        txtsviewAll.setText("your Inputs");
        txtsviewAll.setTextColor(Color.BLACK);
        txtsviewAll.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams lpz=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lpz.weight=1.5f;
        txtsviewAll.setLayoutParams(lpz);

        LLMain.addView(txtsviewAll);
        return LLMain;

    }

}