package com.example.androidfileinout8_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE
        }, MODE_PRIVATE);

        Button btnRead, btnRmdir;
        btnRead = (Button) findViewById(R.id.btnRead);
        btnRmdir = (Button) findViewById(R.id.btnRmdir);

        final String strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File myDir = new File(strSDpath + "/myDir");



        btnRead.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                myDir.mkdir();
            }
        });
        btnRmdir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                myDir.delete();
            }
        });
    }
}