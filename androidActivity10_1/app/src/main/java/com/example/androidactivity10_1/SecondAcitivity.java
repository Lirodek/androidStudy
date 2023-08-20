package com.example.androidactivity10_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SecondAcitivity extends Activity{
    BtnOnClickListener onClickListener = new BtnOnClickListener() ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        setTitle("SecondActivity");
        Button btn = (Button) findViewById(R.id.btn2);
        btn.setOnClickListener(onClickListener);
    }
    class BtnOnClickListener implements Button.OnClickListener{

        @Override
        public void onClick(View v) {
            finish();
        }
    }

}
