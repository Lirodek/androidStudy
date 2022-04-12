package com.example.androidadapter11_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gallery gallery = (Gallery) findViewById(R.id.gallary);

        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);
    }
    public class MyGalleryAdapter extends BaseAdapter{
        Context context;
        Integer[] posterID= {
                R.drawable.chizru, R.drawable.elaina0, R.drawable.estell, R.drawable.frang,
                R.drawable.ichika, R.drawable.iroha2, R.drawable.nino, R.drawable.sato6,
                R.drawable.raillgun5, R.drawable.yukinoshita3, R.drawable.yui, R.drawable.shotelaina
        };
        String[] imgNames = {
                "치즈루", "일레이나", "에스텔", "프랑", "이치카", "이로하", "니노", "사토","레일건",
                "유키노", "유이", "단렝이"
        };
        MyGalleryAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(2,2,2,2);
            imageView.setImageResource(posterID[position]);

            final int pos = position;
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);
                    ivPoster.setOnTouchListener(new View.OnTouchListener(){
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            Toast.makeText(MainActivity.this, imgNames[pos], Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    });
                    return false;
                }
            });
            return imageView;
        }
    }
}