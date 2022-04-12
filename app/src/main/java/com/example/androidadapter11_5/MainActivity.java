package com.example.androidadapter11_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    final String[] charactor = {
            "일레이나", "시키모리", "이로하", "유이가하마", "유키노시타",
            "레일건", "사토", "세레나", "이치카", "니노", "치즈루", "세나"
    };
    final Integer[] imgs = {
            R.drawable.elaina0, R.drawable.shikimori, R.drawable.iroha2, R.drawable.yui,
            R.drawable.yukinoshita3, R.drawable.raillgun5, R.drawable.sato6, R.drawable.serena,
            R.drawable.ichika, R.drawable.nino, R.drawable.chizru, R.drawable.sena, R.drawable.saya
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, charactor);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView img = (ImageView) findViewById(R.id.img);
                img.setScaleType(ImageView.ScaleType.FIT_CENTER);
                img.setPadding(5,5,5,5);
                img.setImageResource(imgs[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

}