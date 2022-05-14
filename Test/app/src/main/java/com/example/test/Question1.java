package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

public class Question1 extends AppCompatActivity implements View.OnClickListener{

    Button btnFirst, btnSecond, btnThird;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);
        btnThird = findViewById(R.id.btnThrid);

        btnFirst.setOnClickListener(this);
        btnSecond.setOnClickListener(this);
        btnThird.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if(viewId == R.id.btnFirst) {
            btnFirst.setText("1ST BUTTON");
        }

        else if(viewId == R.id.btnSecond) {
            btnSecond.setText("2ST BUTTON");
        }

        else{
            btnThird.setText("3ST BUTTON");
        }
    }
}