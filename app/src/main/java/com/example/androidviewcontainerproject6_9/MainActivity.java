package com.example.androidviewcontainerproject6_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button start, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewFlipper viewFlip;

        start = (Button) findViewById(R.id.btnPlay);
        stop = (Button) findViewById(R.id.btnStop);

        viewFlip = (ViewFlipper) findViewById(R.id.viewFlip);

        viewFlip.setFlipInterval(1000);

        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewFlip.startFlipping();
            }
        });
        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewFlip.stopFlipping();
            }
        });

    }
}