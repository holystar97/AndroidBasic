package com.example.pbl_touchtest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public static Button red,blue,green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red=findViewById(R.id.button_red);
        blue=findViewById(R.id.button_blue);
        green=findViewById(R.id.button_green);


    }

}

