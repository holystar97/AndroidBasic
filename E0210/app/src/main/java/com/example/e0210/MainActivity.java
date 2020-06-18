package com.example.e0210;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=(ImageView)findViewById(R.id.image);
    }

    public void mOnClick(View v){

        if(image.getVisibility()==View.VISIBLE){
            image.setVisibility(View.GONE);
        }else{
            image.setVisibility(View.VISIBLE);
        }
    }

}
