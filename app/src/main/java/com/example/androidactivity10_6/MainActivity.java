package com.example.androidactivity10_6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button enterBtn;
    EditText edt1, edt2;
    RadioGroup radioGroup;
    Integer[] rds = new Integer[4];
    RadioButton rd[] = new RadioButton[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Integer[] rds = {R.id.plus, R.id.sub, R.id.mul, R.id.Div};
        enterBtn = (Button) findViewById(R.id.accumulator);

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);

        radioGroup = (RadioGroup) findViewById(R.id.rdGroup);

        for(int i=0; i<rds.length; i++){
            rd[i] = (RadioButton) findViewById(rds[i]);
        }
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                switch ((Integer)radioGroup.getCheckedRadioButtonId()){
                    case R.id.plus:
                        intent.putExtra("Calc", "+");
                        break;
                    case R.id.sub:
                        intent.putExtra("Calc", "-");
                        break;
                    case R.id.mul:
                        intent.putExtra("Calc", "*");
                        break;
                    case R.id.Div:
                        intent.putExtra("Calc", "/");
                        break;
                }

                intent.putExtra("num1", Integer.parseInt(edt1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(edt2.getText().toString()));

                startActivityForResult(intent, 101);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            int hap = data.getIntExtra("hap", 0);
            Toast.makeText(this, "결과 : "+hap, Toast.LENGTH_SHORT).show();
        }
    }
}