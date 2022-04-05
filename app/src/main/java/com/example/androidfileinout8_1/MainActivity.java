package com.example.androidfileinout8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRead, btnWrite;
        btnRead = (Button) findViewById(R.id.fileRead);
        btnWrite = (Button) findViewById(R.id.fileInput);

        btnWrite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream outFs = openFileOutput("file.txt",
                            Context.MODE_PRIVATE);
                    String str = "쿡앱 안드로이드";
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), "파일입력완료", Toast.LENGTH_SHORT).show();
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream inFs = openFileInput("file.txt");
                    byte[] txt = new byte[30];
                    inFs.read(txt);
                    String str = new String(txt);
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    inFs.close();
                } catch (IOException e){}
            }
        });
    }
}