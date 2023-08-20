package com.example.androidadapter11_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView prec_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] index = {
                "일레이나", "시키모리", "이로하", "유이가하마",
                "유키노시타", "레일건", "사토" , "세레나",
                "이치카", "니노", "치즈루", "세나",
                "프랑", "에스텔", "사야", "단발일렝이"
        };
        prec_list = (ListView) findViewById(R.id.frec_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, index);
        prec_list.setAdapter(adapter);

        prec_list.setChoiceMode(ListView.CHOICE_MODE_NONE);
        prec_list.setAdapter(adapter);
        prec_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, index[position], Toast.LENGTH_SHORT).show();
            }
        });
//        prec_list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, index[position], Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}