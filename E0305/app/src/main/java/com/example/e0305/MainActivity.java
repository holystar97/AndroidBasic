package com.example.e0305;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.RadioAccessSpecifier;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLayoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    mLayoutMain=(LinearLayout)findViewById(R.id.layoutMain);

    int id=R.id.radioGreen;
    RadioGroup Colorgroup=(RadioGroup)findViewById(R.id.groupColor);
    Colorgroup.check(id);
    changeColor(id);
    }

    public void mOnClick(View v){
        changeColor(v.getId());
    }


    private void changeColor(int id){
        switch (id){
                case R.id.radioRed:
                mLayoutMain.setBackgroundColor(0xffff0000);
                break;

                case R.id.radioGreen:
                mLayoutMain.setBackgroundColor(0xff00ff00);
                break;

                case R.id.radioBlue:
                mLayoutMain.setBackgroundColor(0xff0000ff);
                break;
        }
    }


}
