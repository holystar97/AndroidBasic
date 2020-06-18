package com.example.pbl_touchtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    public static int red, blue, green;
    public static RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg=findViewById(R.id.radioGroup);
        red= R.id.button_red;
        blue= R.id.button_blue;
        green= R.id.button_green;
    }
}
