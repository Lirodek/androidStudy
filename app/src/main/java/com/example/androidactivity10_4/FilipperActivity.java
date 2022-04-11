package com.example.androidactivity10_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;

public class FilipperActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filipper_activity);

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");

        Integer imageFiledId[] = {
                R.drawable.elaina, R.drawable.shikimori, R.drawable.chizru,
                R.drawable.chika, R.drawable.chizru, R.drawable.sena,
                R.drawable.irohas, R.drawable.utaha, R.drawable.frenda
        };
        int tempResult;
        int tempId;
        for (int i = 0; i < voteResult.length - 1; i++) {
            for (int j = 0; j < voteResult.length-1; j++) {
                if (voteResult[j] > voteResult[j + 1]) {
                    tempResult = voteResult[j];
                    tempId = imageFiledId[j];

                    voteResult[j] = voteResult[j + 1];
                    imageFiledId[j] = imageFiledId[j + 1];

                    voteResult[j + 1] = tempResult;
                    imageFiledId[j + 1] = tempId;
                }
            }
        }
        Integer ivId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4,
                R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
        for(int i =0; i <ivId.length; i++){
            ImageView iv = (ImageView)findViewById(ivId[voteResult.length - i - 1]);
            iv.setImageResource(imageFiledId[i]);
        }

        Button btnStart = (Button) findViewById(R.id.btnStart);
        Button btnPause = (Button) findViewById(R.id.btnStop);
        Button btnReturn = (Button) findViewById(R.id.returnBtn);

        final ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        viewFlipper.setFlipInterval(1000);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.startFlipping();
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.stopFlipping();
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
