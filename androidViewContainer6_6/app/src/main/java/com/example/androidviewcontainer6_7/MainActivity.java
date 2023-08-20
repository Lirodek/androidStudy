package com.example.androidviewcontainer6_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewFlipper viewFlip;

        btnPrev = (Button) findViewById(R.id.btnprev);
        btnNext = (Button) findViewById(R.id.btnnext);

        viewFlip = (ViewFlipper) findViewById(R.id.viewFlipper);

        btnPrev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewFlip.showPrevious();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewFlip.showNext();
            }
        });
    }
}