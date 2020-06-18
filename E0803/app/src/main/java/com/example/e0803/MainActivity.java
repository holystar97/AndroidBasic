package com.example.e0803;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.VectorEnabledTintResources;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditNum1;
    private EditText mEditNum2;
    private String str=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditNum1=(EditText)findViewById(R.id.editNum1);
        mEditNum2=(EditText)findViewById(R.id.editNum2);
        RadioGroup rg=(RadioGroup)findViewById(R.id.radiogroup1);

    }




    public void mOnClick(View v) {
        switch (v.getId()){
            case R.id.add:
                str="add";
                break;
            case R.id.minus:
                str="minus";
                break;
            case R.id.multiply:
                str="multiply";
                break;
            case R.id.divide:
                str="divide";
                break;
        }
    }

    public void mOnClick2(View v){

        Intent intent=new Intent(this,SubActivity.class);
        intent.putExtra("num1",Integer.parseInt(mEditNum1.getText().toString()));
        intent.putExtra("num2",Integer.parseInt(mEditNum2.getText().toString()));
        intent.putExtra("oper",str);

        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode==0 && resultCode==RESULT_OK){
            int result=data.getIntExtra("result",0);
            Bundle oper=data.getExtras();
           String operation= oper.getString("oper");
            Toast.makeText(this,"두 숫자의 "+operation+" : " + result,Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
}
