package com.example.e0802;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.nio.channels.InterruptedByTimeoutException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v){
        Intent intent=new Intent();
        switch(v.getId()) {
            case R.id.btnTest1:
                intent.setAction("andbook.example.implicitintents1.TEST1");
                break;
            case R.id.btnTest2:
                intent.setAction("andbook.example.implicitintents.TEST2");
                break;
            case R.id.btnTest3:
                intent.setAction(Intent.ACTION_MAIN);
                break;
            case R.id.btnTest4:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:010-222-3333"));
                break;
            case R.id.btnTest5:
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.android.com"));
                break;
            case R.id.btnTest6:
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(intent.CATEGORY_HOME);
                break;
        }
        startActivity(intent);
    }


}
