package com.example.androidmessagebox7_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    View toastView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE))
                        .getDefaultDisplay();
                int xOffset = (int) (Math.random() * display.getWidth());
                int yOffset = (int) (Math.random() * display.getHeight());

                Toast toast = new Toast(getApplicationContext());
                toastView = (View) View.inflate(getApplicationContext(),
                        R.layout.toast, null);
                toast.setView(toastView);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                toast.show();
            }
        });
    }
}