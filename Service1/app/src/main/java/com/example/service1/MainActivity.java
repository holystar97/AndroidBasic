package com.example.service1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;

import com.example.service1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    HandlerThread handlerThread;
    Handler handler;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(handlerThread!=null &&handlerThread.isAlive())
                    return;
                //thread start
                num=0;
                handlerThread=new HandlerThread("my handler thread");
                handlerThread.start();
                handler = new Handler(handlerThread.getLooper()){
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        if(msg.what ==0 ){
                            // ui update
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mainBinding.textView.setText(String.format("%d",num++));
                                }
                            });
                            Message m= Message.obtain();
                            m.what=0;
                            sendMessageDelayed(m,1000);
                        }else if (msg.what ==-1){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mainBinding.textView.setText("Thread end");
                                }
                            });
                           getLooper().quit();
                        }
                    }
                };
                Message m= Message.obtain();
                m.what=0;
                handler.sendMessage(m);
            }
        });

        mainBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(handlerThread!=null &&handlerThread.isAlive()) {
                    Message m = Message.obtain();
                    m.what = -1;
                    handler.sendMessage(m);
                }
            }
        });

    }
}
