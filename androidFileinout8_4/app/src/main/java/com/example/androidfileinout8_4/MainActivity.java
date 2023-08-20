package com.example.androidfileinout8_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRead;
        final EditText edtRaw;
        btnRead = (Button) findViewById(R.id.btnRead);
        edtRaw = (EditText) findViewById(R.id.edtRead);

//        btnRead.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                try{
//                    InputStream inputS = getResources().openRawResource(R.raw.raw_test);
//                    byte[] txt = new byte[inputS.available()];
//                    inputS.read(txt);
//                    edtRaw.setText(new String(txt));
//                    inputS.close();
//                } catch (IOException e){
//
//                }
//            }
//        });


    }
}