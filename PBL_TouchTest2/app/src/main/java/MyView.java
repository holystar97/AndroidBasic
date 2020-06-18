package com.example.pbl_touchtest2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import static com.example.pbl_touchtest2.MainActivity.red;

class MyPoint{
    float x,y;
    int  color;
    MyPoint(float x, float y, int c){
        this.x=x;
        this.y=y;
        this.color=c;
    }
}



public class MyView extends View {

    private static final int R=10;
    private ArrayList<MyPoint> mPoints=new ArrayList<>();
    private Paint mPaint =new Paint();
    private int mCurColor = Color.RED;


    public MyView(Context context){
        super(context);
    }
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPaintColor(int color){

        mCurColor=color;
    }






    @Override
    protected void onDraw(Canvas canvas) {

        MainActivity.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == MainActivity.red){
                    setPaintColor(Color.RED);
                }
                else if (checkedId==MainActivity.green){
                    setPaintColor(Color.GREEN);

                }else if (checkedId==MainActivity.blue){
                    setPaintColor(Color.BLUE);
                }
            }
        });

/*
        class MyClickListener implements View.OnClickListener{
            @Override
            public void onClick(View v) {
                    if(v==MainActivity.red){
                        setPaintColor(Color.RED);
                    }else if(v==MainActivity.green){
                        setPaintColor(Color.GREEN);
                    }else if(v==MainActivity.blue){
                        setPaintColor(Color.BLUE);
                    }
                }
            }

        MainActivity.red.setOnClickListener(new MyClickListener());

        MainActivity.blue.setOnClickListener(new MyClickListener());

        MainActivity.green.setOnClickListener(new MyClickListener());

*/

        for(int i=0;i<mPoints.size(); i+=2){
            MyPoint myPoint=mPoints.get(i);
            mPaint.setColor(myPoint.color);
            canvas.drawRect(myPoint.x-R, myPoint.y-R, myPoint.x+R, myPoint.y+R,mPaint);


        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

            case MotionEvent.ACTION_MOVE:

                mPoints.add(new MyPoint(event.getX(), event.getY(), mCurColor));
                invalidate();
                return true;

            case MotionEvent.ACTION_UP:
                return true;
        }
        return super.onTouchEvent(event);
    }
}