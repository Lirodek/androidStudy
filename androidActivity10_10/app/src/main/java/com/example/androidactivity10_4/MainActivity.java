package com.example.androidactivity10_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int voteCount[] = new int[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("내가 좋아하는 캐릭터");
        ImageView[] img = new ImageView[9];

        img[0] = (ImageView) findViewById(R.id.elaina0);
        img[1] = (ImageView) findViewById(R.id.shikimori1);
        img[2] = (ImageView) findViewById(R.id.chizru2);
        img[3] = (ImageView) findViewById(R.id.chika3);
        img[4] = (ImageView) findViewById(R.id.nino4);
        img[5] = (ImageView) findViewById(R.id.sena5);
        img[6] = (ImageView) findViewById(R.id.irohas6);
        img[7] = (ImageView) findViewById(R.id.utaha7);
        img[8] = (ImageView) findViewById(R.id.frenda8);


        for(int i= 0;i<9;i++)
            voteCount[i] = 0;
        final String imgNames[] = {
                "일레이나", "시키모리", "치즈루", "이치카", "니노"
                ,"세나", "이로하" , "우타하", "프렌다"
        };

        for(int i=0;i<img.length;i++){
            final int idx = i;
            img[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[idx]++;
                    Toast.makeText(MainActivity.this, imgNames[idx]+"에게 투표하였습니다. 총["+voteCount[idx]+"]표 득표", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch(item.toString()) {
            case "순위보기":
                intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);
                startActivity(intent);
                break;
            case "명예의 전당":
                intent = new Intent(getApplicationContext(), FilipperActivity.class);
                intent.putExtra("VoteCount", voteCount);
                startActivity(intent);
                break;


        }
        return true;
    }
}