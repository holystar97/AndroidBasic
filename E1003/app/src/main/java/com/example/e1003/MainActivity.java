package com.example.e1003;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyThread mThread;
    private int mNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mThread=new MyThread();
        mThread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Message msg=Message.obtain();
        msg.what=-1;
        mThread.mHandler.sendMessage(msg);
    }

    public void mOnClick(View v){
        Message msg=Message.obtain();
        msg.what=0;
        msg.arg1 = ++mNumber;
        mThread.mHandler.sendMessage(msg);
    }


    private class MyThread extends Thread{
        public Handler mHandler;

        @Override
        public void run() {
            Looper.prepare();
            mHandler=new Handler(){
                @Override
                public void handleMessage(@NonNull Message msg) {
                   if(msg.what==0){
                       try {
                           Thread.sleep(3000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       // 계산 결과 출력
                       int result=msg.arg1* msg.arg1;
                       Log.d("test",msg.arg1+"*" + msg.arg1+ "=" + result);
                   }else if (msg.what==-1){
                       Looper.myLooper().quit();
                       Log.d("test", "루퍼를 종료합니다");
                   }
                }
            };
            Looper.loop();
            Log.d("test", "스레드를 종료합니다.");
        }
    }

}

