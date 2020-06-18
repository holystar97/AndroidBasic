package com.example.pbl_menu;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import java.util.ArrayList;


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

    private static final int R=20;
    private ArrayList<MyPoint> mPoints1=new ArrayList<>();
    private ArrayList<MyPoint> mPoints2=new ArrayList<>();
    private ArrayList<MyPoint> mPoints3=new ArrayList<>();
    private Paint mPaint =new Paint();
    private int mCurColor;
    private static String width;
    private static String color;
    private Path path= new Path();
    public static void send(String color){
      MyView.color=color;
    }

    public static void send2(String width){
        MyView.width=width;
    }


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

        if (color == null)
            setPaintColor(Color.RED);
        else {
            switch (color) {
                case "빨강":
                    setPaintColor(Color.RED);
                    break;
                case "청록":
                    setPaintColor(Color.CYAN);
                    break;
                case "노랑":
                    setPaintColor(Color.YELLOW);
                    break;
                case "초록":
                    setPaintColor(Color.GREEN);
                    break;
                case "파랑":
                    setPaintColor(Color.BLUE);
                    break;
                case "자주":
                    setPaintColor(Color.MAGENTA);
                default:
                    break;
            }
        }
/*
        MainActivity.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == MainActivity.red) {
                    setPaintColor(Color.RED);
                } else if (checkedId == MainActivity.green) {
                    setPaintColor(Color.GREEN);

                } else if (checkedId == MainActivity.blue) {
                    setPaintColor(Color.BLUE);
                }
            }
        });
*/

        for (int i = 0; i < mPoints1.size(); i += 2) {
            MyPoint myPoint = mPoints1.get(i);
            mPaint.setColor(myPoint.color);
            canvas.drawRect(myPoint.x - R, myPoint.y - R, myPoint.x + R, myPoint.y + R, mPaint);
        }
        for (int i = 0; i < mPoints2.size(); i += 2) {
            MyPoint myPoint = mPoints2.get(i);
            mPaint.setColor(myPoint.color);
            canvas.drawCircle(myPoint.x, myPoint.y, R, mPaint);
        }

        for (int i = 0; i < mPoints3.size(); i += 2) {
            MyPoint myPoint = mPoints3.get(i);
            mPaint.setColor(myPoint.color);
            int side = 20;
            int height = 30;
            path.reset();
            path.moveTo(myPoint.x, myPoint.y);
            path.lineTo(myPoint.x - side, myPoint.y + height);
            path.lineTo(myPoint.x + side, myPoint.y + height);
            path.close();
            canvas.drawPath(path, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (color == null)
                    setPaintColor(Color.RED);
                else {
                    switch (color.toString()) {
                        case "빨강":
                            setPaintColor(Color.RED);
                            break;
                        case "청록":
                            setPaintColor(Color.CYAN);
                            break;
                        case "노랑":
                            setPaintColor(Color.YELLOW);
                            break;
                        case "초록":
                            setPaintColor(Color.GREEN);
                            break;
                        case "파랑":
                            setPaintColor(Color.BLUE);
                            break;
                        case "자주":
                            setPaintColor(Color.MAGENTA);
                        default:
                            break;
                    }
                }
            case MotionEvent.ACTION_MOVE:

                if (width == null)
                    mPoints1.add(new MyPoint(event.getX(), event.getY(), mCurColor));
                else {
                    switch (width) {
                        case "사각형":
                            mPoints1.add(new MyPoint(event.getX(), event.getY(), mCurColor));
                            break;
                        case "원":
                            mPoints2.add(new MyPoint(event.getX(), event.getY(), mCurColor));
                            break;
                        case "세모":
                            mPoints3.add(new MyPoint(event.getX(), event.getY(), mCurColor));
                            break;
                        default:
                            break;
                    }
                }

                invalidate();
                return true;

            case MotionEvent.ACTION_UP:
                return true;
        }
        return super.onTouchEvent(event);
    }
}