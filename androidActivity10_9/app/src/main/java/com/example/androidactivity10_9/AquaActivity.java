package com.example.androidactivity10_9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class AquaActivity  extends Activity {
    LinearLayout aqua;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        aqua = (LinearLayout) findViewById(R.id.thirdlayout);
        aqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MisakaFriendActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
