package com.example.androidactivity10_7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn[] = new Button[6];
    Intent intent;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer btns[] = {R.id.call, R.id.homepage, R.id.map, R.id.search, R.id.sendmail,
                R.id.picture};
        for(int i = 0; i<btns.length; i++){
            btn[i] = (Button) findViewById(btns[i]);
        }
        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("tel:010-9313-33895");

            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://github.com/Lirodek");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://maps.google.com/maps?q="+37.559133+","+126.927824);
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intent);
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("smsbody", "안녕하세요?");
                intent.setData(Uri.parse("smsto:"+ Uri.encode("010-9313-3895")));
                startActivity(intent);

            }
        });
        btn[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);

            }
        });
    }
}