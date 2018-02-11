package com.example.ranak.algorithmlearner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;


public class simulation extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_simulation);

        final int arraylength=Integer.parseInt(getIntent().getExtras().getString("arraylength"));
        final String sortType=getIntent().getExtras().getString("Sort type");
        final int[] data=new int[arraylength];
        for (int i=0;i<arraylength;i++)
        {
            data[i]=getIntent().getExtras().getInt(""+i);
        }

        final CustomView view=(CustomView)findViewById(R.id.view);
        view.DrawCircle(arraylength,data,sortType);
        view.setVerticalScrollBarEnabled(true);
        Button button=(Button) findViewById(R.id.next);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sortType.equals("Insertion"))
                {

                    for (int j = 0; j < arraylength-1; j++) {
			/* find the min element in the unsorted a[j .. n-1] */

			/* assume the min is the first element */
                        int iMin = j;
			/* test against elements after j to find the smallest */
                        for ( int i = j+1; i < arraylength; i++) {
				/* if this element is less, then it is the new minimum */
                            if (data[i] < data[iMin]) {
					/* found new minimum; remember its index */
                                iMin = i;
                            }
                        }

			/* iMin is the index of the minimum element. Swap it with the current position */
                        if ( iMin != j ) {
                            int  temp = data[j];
                            data[j]=data[iMin];
                            data[iMin]=temp;
                            view.DrawCircle(arraylength,data,sortType);
                            view.swapedData(data[iMin],data[j]);
                            break;
                        }
                    }

                }
                else if(sortType.equals("Bubble"))
                {
                    int flags=0;

                    for(int i=0;i<arraylength-1;i++)
                    {
                        for(int j=i+1;j<arraylength;j++)
                        {
                           if(data[i]>data[j])
                           {
                               int temp=data[i];
                               data[i]=data[j];
                               data[j]=temp;
                               view.DrawCircle(arraylength,data,sortType);
                               view.swapedData(data[i],data[j]);
                               flags=1;
                               break;

                           }


                        }
                        if(flags==1)
                        {
                            flags=0;
                            break;
                        }

                    }

                    //view.swapedData(data[i],data[j]);

                }

            }
        });

    }



}
