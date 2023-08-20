package com.example.androidactivity10_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    Button btn;
    onclick on = new onclick();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        System.out.println("여기도착");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        btn = (Button) findViewById(R.id.btn1);

        btn.setOnClickListener(on);


    }
    private class onclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            finish();
        }
    }
}
