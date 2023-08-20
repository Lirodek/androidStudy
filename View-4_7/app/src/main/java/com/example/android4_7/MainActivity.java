package com.example.android4_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tx1, tx2;
    CheckBox ch1;
    RadioGroup radioGroup;
    RadioButton rElaina, rMisaka, rSato;
    Button btn;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("좋아하는 애니캐릭터 고르기");

        tx1 = (TextView) findViewById(R.id.text1);
        ch1 = (CheckBox) findViewById(R.id.ch1);

        tx2 = (TextView) findViewById(R.id.text2);
        radioGroup = (RadioGroup) findViewById(R.id.RadiGroup);
        rElaina = (RadioButton) findViewById(R.id.radiElaina);
        rMisaka = (RadioButton) findViewById(R.id.radiMisaka);
        rSato = (RadioButton) findViewById(R.id.radiSato);
        btn = (Button) findViewById(R.id.btnChoice);
        img = (ImageView) findViewById(R.id.imageView1);

        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ch1.isChecked() == true){
                    tx2.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                } else {
                    tx1.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch(radioGroup.getCheckedRadioButtonId()){
                    case R.id.radiElaina:
                        img.setImageResource(R.drawable.elaina);
                        break;
                    case R.id.radiMisaka:
                        img.setImageResource(R.drawable.misaka);
                        break;
                    case R.id.radiSato:
                        img.setImageResource(R.drawable.sato);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "애니캐릭터 먼저 선택하세요",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}