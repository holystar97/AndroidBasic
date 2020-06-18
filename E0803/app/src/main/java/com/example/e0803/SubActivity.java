package com.example.e0803;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class SubActivity extends AppCompatActivity {

    private int num1;
    private int num2;
    private String str=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView textNum1=(TextView)findViewById(R.id.textNum1);
        TextView textNum2=(TextView)findViewById(R.id.textNum2);

        Intent intent=getIntent();
        num1=intent.getIntExtra("num1",-1);
        num2=intent.getIntExtra("num2",-1);
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            str=extras.getString("oper");
        }
        if(num1 !=-1 && num2 !=-1){
            textNum1.setText(String.format(Locale.KOREAN,"숫자1 : %d ", num1));
            textNum2.setText(String.format(Locale.KOREAN,"숫자2 : %d ", num2));
        }
    }
    public void mOnClick(View v){

        Intent data= new Intent();
        switch(str){
            case "add":
                data.putExtra("oper","합");
                data.putExtra("result",num1+num2);
                break;
            case "minus":
                data.putExtra("oper","차");
                data.putExtra("result",num1-num2);
                break;
            case "multiply":
                data.putExtra("oper","곱");
                data.putExtra("result",num1*num2);
                break;
            case "divide":
                data.putExtra("oper","몫");
                data.putExtra("result",num1/num2);
                break;
        }
        setResult(RESULT_OK,data);
        finish();


    }


}
