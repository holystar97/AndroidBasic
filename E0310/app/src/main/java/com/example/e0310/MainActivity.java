package com.example.e0310;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RatingBar mRatingVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRatingVote=(RatingBar)findViewById(R.id.ratingVote);
    }

    public void mOnClick(View v){
        switch(v.getId()){
            case R.id.btnDec:
                mRatingVote.incrementProgressBy(-1);
                break;
            case R.id.btnInc:
                mRatingVote.incrementProgressBy(1);
                break;
            case R.id.btnResult:
                Toast.makeText(this,"현재 값 = " +mRatingVote.getRating(),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}