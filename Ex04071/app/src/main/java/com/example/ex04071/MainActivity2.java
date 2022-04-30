package com.example.ex04071;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public  class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    Button but1, but2, but3, but4;
    EditText fristNum, secondNum;
    TextView tv2;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();


    }
    private  void initView() {
        fristNum = findViewById(R.id.fristNum);
        secondNum = findViewById(R.id.secondNum);
        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        but3 = findViewById(R.id.but3);
        but4 = findViewById(R.id.but4);
        tv2 = findViewById(R.id.tv2);


        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        double n1 = Double.parseDouble(fristNum.getText().toString());
        double n2 = Double.parseDouble(secondNum.getText().toString());

        double result;

        if(viewId == R.id.but1){
            result = n1+n2;
        }
        else if(viewId == R.id.but2) {
            result = n1-n2;
        }
        else if(viewId == R.id.but3){
            result = n1*n2;
        }
        else {
            result = n1/n2;

        }
        tv2.setText("연산결과 :"+String.valueOf(result));

    }
}