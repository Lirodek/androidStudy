package com.example.androidlayout_5_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView resultText;
    String num1, num2;
    Integer result;

    Button[] numBtn = new Button[10];
    Integer[] numBtnIDs = {
            R.id.btn0, R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4
            ,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9
    };
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.edit1);
        ed2 = (EditText) findViewById(R.id.edit2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        resultText = (TextView) findViewById(R.id.resultText);
        btnAdd.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = ed1.getText().toString();
                num2 = ed2.getText().toString();

                result =  Integer.parseInt(num1) + Integer.parseInt(num2);
                resultText.setText("계산결과 : "+ result.toString());
                return false;
            }
        });
        btnSub.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = ed1.getText().toString();
                num2 = ed2.getText().toString();

                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                resultText.setText("계산결과 : "+result.toString());
                return false;
            }
        });
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = ed1.getText().toString();
                num2 = ed2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                resultText.setText("계산결과 : "+result.toString());
                return false;
            }
        });
        btnDiv.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = ed1.getText().toString();
                num2 = ed2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                resultText.setText("계산결과 : "+result.toString());
                return false;
            }
        });
        for(i=0;i<numBtnIDs.length;i++){
            final int idx;
            idx = i;
            numBtn[idx].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(ed1.isFocused() == true){
                        num1 = ed1.getText().toString() +
                                numBtn[idx].getText().toString();
                    } else if(ed1.isFocused() == true){
                        num2 = ed2.getText().toString() +
                                numBtn[idx].getText().toString();
                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택해주세요",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}