package com.example.threadtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    public ProgressBar p;
    public int max=100;
    Button btnStart,btnStop;
    boolean flag=true;
    boolean threadFlag=false;
    Handler handler =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart=findViewById(R.id.start);
        btnStop=findViewById(R.id.stop);
        p=findViewById(R.id.progressBar);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=true;
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        p.setMax(max);
                        while(flag){
                            try{
                            // 메인 스레드 영역 시작
                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                    if(p.getProgress() <max){
                                        p.incrementProgressBy(max/100);
                                    }
                                    else{
                                        flag=false;
                                    }
                                }
                            });
                            Thread.sleep(2000/100);
                            // 메인 스레드 영역 끝
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } // end while
                        threadFlag=false;
                    } // end run
                });
                if(!threadFlag){
                    p.setProgress(0);
                    threadFlag=true;
                    t.start();
                }
                // 작업 스레드 영역 끝
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=false;
                p.setProgress(0);
            }
        });
    } // end onCreate

}
