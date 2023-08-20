package com.example.androidmenu7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout imageLayout;
    EditText edit;
    ImageView image;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        edit = findViewById(R.id.edit);
        image = findViewById(R.id.image);
        switch(item.getItemId()){
            case R.id.radians:
               image.setRotation(Float.parseFloat(edit.getText().toString()));
               return true;
            case R.id.watson:
                image.setImageResource(R.drawable.watson);
                item.setChecked(true);
                return true;
            case R.id.gura:
                image.setImageResource(R.drawable.gura);
                item.setChecked(true);
                return true;
            case R.id.mumei:
                image.setImageResource(R.drawable.mumei);
                item.setChecked(true);
                return true;
        }

        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageLayout = findViewById(R.id.imageLayout);
        edit = findViewById(R.id.edit);

    }
}