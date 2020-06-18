package com.example.e0202;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pic=(ImageView) findViewById(R.id.apeach1);
    }

    public void hide(View v){
        pic.setVisibility(View.INVISIBLE);
    }

    public void remove(View v){
        pic.setVisibility(View.GONE);
    }


}
