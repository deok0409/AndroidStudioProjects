package com.example.ex04071;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2;
    TextView tv1;
    int cnt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById((R.id.tv1));
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        tv1.setText(String.valueOf(cnt)); // ""를 붙여 묵시적 형변환을 하여 문자열로 값을 넣어 만듬
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        //String num = tvNum.getText().toString();
        //int n = Integer.parseInt(num);
        if(viewId == R.id.btn1){
            //n += 1;
            //tv1.setText(n+"");
            cnt++;
            tv1.setText(String.valueOf(cnt));
        }
        else{
            //n -= 1;
            //tv1.setText(String.valueof(n))
            if(cnt > 0) {
                cnt--;
                tv1.setText(String.valueOf(cnt));
            }
            }
        }
 }