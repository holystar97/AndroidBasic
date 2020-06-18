package com.example.e0311;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private SeekBar mSeekRed;
    private View mViewColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSeekRed=(SeekBar) findViewById(R.id.seekBar);
        mViewColor=findViewById(R.id.viewColor);

        mViewColor.setBackgroundColor(Color.argb(255,mSeekRed.getProgress(),0,0));
        mSeekRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mViewColor.setBackgroundColor(Color.argb(255,progress,0,0));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
