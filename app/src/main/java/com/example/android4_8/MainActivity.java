package com.example.android4_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;


public class MainActivity extends AppCompatActivity {
    CheckBox[] ch = new CheckBox[3];
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제임");

        ch[0] = (CheckBox) findViewById(R.id.ch1);
        ch[1] = (CheckBox) findViewById(R.id.ch2);
        ch[2] = (CheckBox) findViewById(R.id.ch3);
        btn = (Button) findViewById(R.id.btn);
        ch[0].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    btn.setEnabled(true);
                else
                    btn.setEnabled(false);
            }
        });
        ch[1].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    btn.setClickable(true);
                else
                    btn.setClickable(false);
            }
        });
        ch[2].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    btn.setRotation(45);
                else
                    btn.setRotation(0);
            }
        });
    }
}