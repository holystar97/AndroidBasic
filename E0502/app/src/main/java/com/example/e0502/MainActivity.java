package com.example.e0502;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    private static class MyView extends View{
        private Paint mPaint;

        public MyView(Context context){
            super(context);
            mPaint=new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas){

            mPaint.reset();
            mPaint.setAntiAlias(true);

            mPaint.setStrokeWidth(20);
            canvas.drawPoint(30,30,mPaint);

            mPaint.setStrokeWidth(8);
            canvas.drawLine(50,50,200,100,mPaint);

            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.RED);
            canvas.drawRect(250,50,450,100,mPaint);
            mPaint.setColor(Color.GREEN);
            canvas.drawCircle(100,200,50,mPaint);
            mPaint.setColor(Color.BLUE);
            canvas.drawOval(new RectF(200,150,400,250),mPaint);

            mPaint.setColor(Color.CYAN);
            Path path=new Path();
            path.moveTo(50,300);
            path.lineTo(90,310);
            path.lineTo(110,290);
            path.lineTo(130,330);
            path.lineTo(160,310);
            canvas.drawPath(path,mPaint);

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.MAGENTA);
            mPaint.setTextSize(50);
            mPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("Hello",100,400,mPaint);
        }
    }
}
