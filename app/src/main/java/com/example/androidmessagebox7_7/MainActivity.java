package com.example.androidmessagebox7_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 1:
                imageView1.setImageResource(R.drawable.chrony);
                return true;
            case 2:
                imageView1.setImageResource(R.drawable.chicken);
                return true;
            case 3:
                imageView1.setImageResource(R.drawable.mumei);
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "크로니");
        menu.add(0, 2, 0, "치킨");
        menu.add(0, 3, 0, "부엉이");

        return true;

    }


}