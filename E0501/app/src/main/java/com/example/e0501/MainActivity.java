package com.example.e0501;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView((this)));
    }
    private static class MyView extends View {
        private Paint mPaint;
        public MyView(Context context) {
            super(context);
            mPaint=new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setColor(Color.RED);
        }

        @Override
        protected void onDraw(Canvas canvas){
           // super.onDraw(canvas);
            canvas.drawColor(Color.YELLOW);
            canvas.drawCircle(100,100,80,mPaint);
        }
    }
}
