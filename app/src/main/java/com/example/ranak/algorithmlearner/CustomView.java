package com.example.ranak.algorithmlearner;

/**
 * Created by ranak on 3/1/15.
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomView extends View {


    int numberOfNode=0;
    int rad=0;
    float y=0;
    int swap1=0;
    int swap2=0;
    int[] values;
    DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
    int w = metrics.widthPixels;
    int h = metrics.heightPixels;
    float coor[]=new float[16];
    PointF Pointx1=new PointF();
    PointF Pointx2=new PointF();
    private android.content.Context context;
    List<float[]> rowList = new ArrayList<float[]>();
    //rowList.add(new int[]{buttonnumber,(int)vibrations});



    public CustomView(Context context,AttributeSet attr)
    {
        super(context, attr);
        /*setWillNotDraw(false);
        TypedArray a = context.obtainStyledAttributes(R.styleable.View);
        //initializeScrollbars(a);
        a.recycle();*/

    }

    @Override
    public void onDraw(Canvas canvas) {




        Paint paint = new Paint();

        for(int j=0;j<rowList.size();j++)
        {
            paint.setColor(Color.LTGRAY);
            canvas.drawCircle(rowList.get(j)[0],rowList.get(j)[1],rowList.get(j)[2],paint);
            paint.setTextSize(rowList.get(j)[4]);
            paint.setColor(Color.BLACK);
            canvas.drawText(""+(int)rowList.get(j)[3],rowList.get(j)[0],rowList.get(j)[1],paint);


        }
        float radius=0;
        float x1= rad;
        float mPoint1=0;
        float mPoint2=0;
        float x2=0;

        for (int i=0;i<numberOfNode;i++)
        {

            x2= x1+(2*radius);
            radius= rad;


           if((values[i]==swap1) || (values[i]==swap2))
            {
                paint.setColor(Color.RED);

                if(values[i]==swap1) mPoint2=x2;
                else if(values[i]==swap2) mPoint1=x2;

                Log.d("swap1","start");
                Log.d("Swap1",""+mPoint1);
                Log.d("Swap2",""+mPoint2);
                Log.d("x2",""+mPoint1);

            }
            else
            {
                paint.setColor(Color.LTGRAY);
            }

            canvas.drawCircle(x2, y, radius, paint);
            paint.setTextSize(rad/2);
            paint.setColor(Color.BLACK);
            canvas.drawText(""+values[i],x2,y,paint);
            paint.setTextSize(30);
            //canvas.drawText(""+mPoint1,60,700,paint);
            //canvas.drawText(""+mPoint2,300,700,paint);
            x1=x2;
            rowList.add(new float[]{x2,y,radius,values[i],rad/2});

        }

        //mPoint2=x2;
        //y+=(rad+rad);


        DrawArrow(canvas,mPoint1,mPoint2,y);


    }
    public void DrawCircle(int numberOfNode,int[] data,String type)
    {

        values=data;
        this.numberOfNode=numberOfNode;
        rad=(w/16)/2;
        y+=(rad+rad);
        if(type.equals("Insertion"))
        {
            y+=rad;
        }
        invalidate();

    }
    public void swapedData(int swap1,int swap2)
    {
        this.swap1=swap1;
        this.swap2=swap2;
    }
    /*private Path drawCurve(Canvas canvas, Paint paint, PointF mPointa, PointF mPointb) {

        Path myPath = new Path();
        //myPath.moveTo(63*w/64, h/10);
        myPath.quadTo(mPointa.x, mPointa.y, mPointb.x, mPointb.y);
        return myPath;
    }*/
    private void DrawArrow(Canvas canvas, float x1 , float x2 ,float y)
    {
        //to draw an arrow, just lines needed, so style is only STROKE
        Paint paints=new Paint();

        paints.setStyle(Paint.Style.STROKE);
        paints.setColor(Color.RED);

        //create a path to draw on
        Path arrowPath = new Path();

        //create an invisible oval. the oval is for "behind the scenes" ,to set the path´
        //area. Imagine this is an egg behind your circles. the circles are in the middle of this egg
        final RectF arrowOval = new RectF();
        arrowOval.set(x1,y-80,x2,y+80);

        //add the oval to path
        arrowPath.addArc(arrowOval,-180,180);

        //draw path on canvas

        canvas.drawPath(arrowPath, paints);

        //draw arrowhead on path start
        arrowPath.moveTo(x2,y ); //move to the center of first circle
        arrowPath.lineTo(x1,y-rad);//draw the next arrowhead line to the right

    }

}
