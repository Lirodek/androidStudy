package com.example.androidadapter11_5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    MyGraphicView graphicView;
    static Integer selectedPoster;

    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float skewX = 0, skewY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout picture = (LinearLayout) findViewById(R.id.picture);
        graphicView = new MyGraphicView(this);
        picture.addView(graphicView);

        registerForContextMenu(graphicView);

        final String[] movie = {
                "일레이나", "이로하스", "유키농", "유이", "사야", "프랑",
                "시키모리", "니노", "이치카", "세레나"
        };
        final Integer[] posterId = { R.drawable.elaina0, R.drawable.iroha2, R.drawable.yukinoshita3,
        R.drawable.yui, R.drawable.saya, R.drawable.frang, R.drawable.shikimori, R.drawable.nino,
        R.drawable.ichika, R.drawable.serena};
        selectedPoster = posterId[0];

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, movie);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPoster = posterId[position];
                scaleX = 1;
                scaleY = 1;
                angle = 0;
                skewX = 0;
                skewY = 0;
                graphicView.invalidate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 1:
                angle += 20;
                graphicView.invalidate();
                return true;
            case 2:
                scaleX += 0.2f;
                scaleY += 0.2f;
                graphicView.invalidate();
                return true;
            case 3:
                scaleX -= 0.2f;
                scaleY -= 0.2f;
                graphicView.invalidate();
                return true;
            case 4:
                skewX += 0.1f;
                skewY += 0.1f;
                graphicView.invalidate();
                return true;
            case 5:
                skewX -= 0.1f;
                skewY -= 0.1f;
                graphicView.invalidate();
                return true;


        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v == graphicView){
            menu.add(0,1,0,"회전");
            menu.add(0,2,0,"확대");
            menu.add(0,3,0,"축소");
            menu.add(0,4,0,"기울기 증가");
            menu.add(0,5,0,"기울기 감소");
        }
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context){super(context);}

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;

            canvas.skew(skewX, skewY);
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Bitmap picture = BitmapFactory.decodeResource(getResources(), selectedPoster);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, null);

            picture.recycle();
        }
    }
}