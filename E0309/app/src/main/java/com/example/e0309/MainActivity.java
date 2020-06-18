package com.example.e0309;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgStatus =(ProgressBar)findViewById(R.id.progStatus);

    }

    public void mOnClick(View v){
        switch(v.getId()) {
            case R.id.bnDecrease1:
                mProgStatus.setProgress(mProgStatus.getProgress()-5);
            case R.id.bnIncrease1:
                mProgStatus.setProgress(mProgStatus.getProgress()+5);
            case R.id.bnDecrease2:
                mProgStatus.setProgress(mProgStatus.getSecondaryProgress()-5);
            case R.id.bnIncrease2:
                mProgStatus.setProgress(mProgStatus.getSecondaryProgress()+5);
        }
    }


}
