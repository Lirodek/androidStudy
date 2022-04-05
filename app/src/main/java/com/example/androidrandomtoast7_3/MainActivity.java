package com.example.androidrandomtoast7_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = findViewById(R.id.button1);
        final Button button2 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast tMsg  = Toast.makeText(MainActivity.this,
                        "토스트 연습",Toast.LENGTH_SHORT);
                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int xOffset = (int) (Math.random() * display.getWidth());
                int yOffset = (int) (Math.random() * display.getHeight());

                tMsg.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                tMsg.show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Snackbar.make(v,"스낵바 입니다.", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}