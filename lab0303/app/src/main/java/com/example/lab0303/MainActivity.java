package com.example.lab0303;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText mNum1,mNum2;
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v){
        mNum1=(EditText)findViewById(R.id.num1);
        mNum2=(EditText)findViewById(R.id.num2);
        int num1=Integer.parseInt(mNum1.getText().toString());
        int num2=Integer.parseInt(mNum2.getText().toString());
        mResult=(TextView)findViewById(R.id.result);

        int add=num1+num2;
        int minus=num1-num2;
        int mul=num1*num2;
        double div=num1/(double)num2;

        DecimalFormat format=new DecimalFormat(".#");
        String div2=format.format(div);

        mResult.setText(Integer.toString(add)+", "+Integer.toString(minus)+", "+Integer.toString(mul)+", "+div2);

    }
}
