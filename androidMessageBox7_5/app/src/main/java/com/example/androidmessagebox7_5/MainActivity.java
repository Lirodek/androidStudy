package com.example.androidmessagebox7_5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn1 = findViewById(R.id.button1);
        img = findViewById(R.id.charactors);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String[] versionArray = new String[] {"유키노","이로하스","유이"};
                final boolean[] checkArray = new boolean[] {true, false, false};
                AlertDialog.Builder dlg =
                        new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 사람은 ? ");
                dlg.setIcon(R.drawable.test);
                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                       switch(which){
                                case 0:
                                    img.setImageResource(R.drawable.yukino);
                                    break;
                                case 1:
                                    img.setImageResource(R.drawable.irohas);
                                    break;
                                case 2:
                                    img.setImageResource(R.drawable.yui);
                                    break;
                            }
                        }
                    });
                dlg.setPositiveButton("닫기", null);
                dlg.show();
            }
        });
    }
}