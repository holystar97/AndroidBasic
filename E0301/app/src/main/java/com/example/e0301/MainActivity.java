package com.example.e0301;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView,imgTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=(TextView) findViewById(R.id.test1);

        mTextView.setText("테스트 문장 #1\n Test sentence #1");
        mTextView.setTextColor(Color.parseColor("#ff00ff"));
        mTextView.setTypeface(Typeface.SERIF);

        imgTextView=(TextView) findViewById(R.id.imgText);

        imgTextView.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.ic_launcher,0,0);

    }
}
