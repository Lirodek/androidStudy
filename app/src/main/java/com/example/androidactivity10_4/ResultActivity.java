package com.example.androidactivity10_4;

import android.app.Activity;
import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends Activity {
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        Intent intent = getIntent();
        btn =(Button) findViewById(R.id.btn_return);
        int[] voteResult = intent.getIntArrayExtra("VoteCount");

        RatingBar rbar[] = new RatingBar[voteResult.length];
        Integer[] rtBar = {R.id.star0, R.id.star1, R.id.star2, R.id.star3,
                R.id.star4, R.id.star5, R.id.star6, R.id.star7, R.id.star8};
        for (int i = 0; i < voteResult.length; i++) {
            rbar[i] = (RatingBar) findViewById(rtBar[i]);
            rbar[i].setRating((float) voteResult[i]);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
