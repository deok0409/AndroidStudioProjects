package com.example.ex0406;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;


public abstract class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2,btn3;
    ConstraintLayout layout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        layout2= findViewById(R.id.layout2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.btn1) {
            layout2.setBackgroundColor(Color.parseColor("#CD0000"));

        } else if (viewId == R.id.btn2) {
            layout2.setBackgroundColor(Color.parseColor("#006400"));

        } else {
            layout2.setBackgroundColor(Color.parseColor("#0000FF"));

        }
    }

}