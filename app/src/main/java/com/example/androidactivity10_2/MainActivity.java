package com.example.androidactivity10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    Button btn;
    RadioButton rd1, rd2;
    onclick on = new onclick();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);

        rd1 = (RadioButton) findViewById(R.id.rd1);
        rd2 = (RadioButton) findViewById(R.id.rd2);

        btn.setOnClickListener(on);
    }

    class onclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {


            Intent intent;
            if (rd1.isChecked() == true) {
                System.out.println(rd1.isChecked());
                intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
            } else {
                intent = new Intent(getApplicationContext(),
                        ThirdAcitivity.class);
            }
            startActivity(intent);
        }
    }
}
