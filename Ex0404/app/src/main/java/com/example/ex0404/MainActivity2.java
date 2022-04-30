package com.example.ex0404;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //TextView를 참조하는 객체생성 => View 초기화(★★★★★)
        TextView tvData = findViewById(R.id.tvData);

        tvData.setText("텍스트뷰 초기화!");

        //TextView의 배경색 변경 2가지 Color, Color.parseColor

        //1.정해진 색상 활용
        //tvData.setBackgroundColor(Color.DKGRAY);

        //2.16진수로 색상 적용
        tvData.setBackgroundColor(Color.parseColor("#ff0000"));

        //TextView의 글자색 변경

        //1.정해진 색상 활용
        //tvData.setTextColor(Color.BLUE);

        //2.16진수로 색상 적용
        tvData.setTextColor(Color.parseColor("#ffffff"));
    }
}