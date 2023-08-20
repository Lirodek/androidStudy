package com.example.androidadapter11_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridView gv = (GridView)findViewById(R.id.gridView);
        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gv.setAdapter(gridAdapter);
    }
    public class MyGridAdapter extends BaseAdapter{
        Context context;
        Integer[] posterID = {
                R.drawable.elaina0, R.drawable.shikimori, R.drawable.iroha2, R.drawable.yui,
                R.drawable.yukinoshita3, R.drawable.raillgun5, R.drawable.sato6, R.drawable.serena,
                R.drawable.ichika, R.drawable.nino, R.drawable.chizru, R.drawable.sena, R.drawable.frang,
                R.drawable.estell, R.drawable.saya, R.drawable.shotelaina ,R.drawable.kyaru, R.drawable.takagi,
                R.drawable.frenda, R.drawable.azsa
        };
        MyGridAdapter(Context c ){
            context = c;
        }
        @Override
        public int getCount() { return posterID.length; }

        @Override
        public Object getItem(int position) { return null; }

        @Override
        public long getItemId(int position) { return 0; }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(2,2,2,2);

            imageView.setImageResource(posterID[position]);
            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle("큰 포스터");
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });
            return imageView;
        }
    }
}