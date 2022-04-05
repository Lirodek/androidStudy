package com.example.androidmessagebox7_9;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rGroup;
    RadioButton rdoElaina, rdoSaya, rdoEstel, rdoNike;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        rdoElaina = (RadioButton) findViewById(R.id.rdoElina);
        rdoSaya = (RadioButton) findViewById(R.id.rdoSaya);
        rdoEstel = (RadioButton) findViewById(R.id.rdoEstel);
        rdoNike = (RadioButton) findViewById(R.id.rdoNike);

        btn = (Button) findViewById(R.id.button);

        final Integer[] radioID = { R.id.rdoElina, R.id.rdoSaya, R.id.rdoEstel, R.id.rdoNike};
        final Integer[] imageID = { R.drawable.elaina, R.drawable.saya, R.drawable.estel, R.drawable.nike};

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int pos = rGroup.getCheckedRadioButtonId();
                View dialogView = (View) View.inflate(MainActivity.this,
                        R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                ImageView iv = (ImageView) dialogView.findViewById(R.id.charactor);
                switch(rGroup.getCheckedRadioButtonId()){
                    case R.id.rdoElina:
                        iv.setImageResource(imageID[0]);
                        dlg.setTitle("일렝이");
                        break;
                    case R.id.rdoSaya:
                        iv.setImageResource(imageID[1]);
                        dlg.setTitle("사양");
                        break;
                    case R.id.rdoEstel:
                        iv.setImageResource(imageID[2]);
                        dlg.setTitle("에스테루");
                        break;
                    case R.id.rdoNike:
                        iv.setImageResource(imageID[3]);
                        dlg.setTitle("니케");
                        break;
                }
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기",  null);
                dlg.show();
            }
        });

    }
}