package com.example.androidactivity10_6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    LinearLayout linear;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);

        Intent inIntent = getIntent();
        int num1 =  inIntent.getIntExtra("num1",0);
        int num2 =  inIntent.getIntExtra("num2",0);

        String calc = (inIntent.getStringExtra("Calc"));

        int calValue = 0;

        switch (calc){
            case "+":
                calValue = num1 + num2;
                break;
            case "-":
                calValue = num1 - num2;
                break;
            case "*":
                calValue = num1 * num2;
                break;
            case "/":
                calValue = num1 / num2;
                break;
        }
        final int retValue = calValue;

        linear = (LinearLayout) findViewById(R.id.second_layoyt);

        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("hap", retValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });

    }
}
