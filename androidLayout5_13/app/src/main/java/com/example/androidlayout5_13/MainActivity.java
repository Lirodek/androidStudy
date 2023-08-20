package com.example.androidlayout5_13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    Button btn;
    RatingBar ratingBar;
    ImageView img;
    CheckBox check;
    int chk = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btnAll);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar1);
        img = (ImageView) findViewById(R.id.img);
        check = (CheckBox) findViewById(R.id.checkbox);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(chk == 0){
                    chk = 1;
                    btn.setText("\"RatingBar\"만 보임");
                    ratingBar.setVisibility(View.VISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    check.setVisibility(View.INVISIBLE);
                } else if(chk == 1){
                    chk=2;
                    btn.setText("\"imageView\"만보임");
                    ratingBar.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.VISIBLE);
                    check.setVisibility(View.INVISIBLE);
                } else {
                    chk=0;
                    btn.setText("\"checkBox\"만보임");
                    ratingBar.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    check.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}