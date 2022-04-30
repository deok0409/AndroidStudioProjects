package com.example.ex0413;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondMainActivity extends AppCompatActivity {

    Button btnSecond;
    TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        btnSecond = findViewById(R.id.btnSecond);
        tvData = findViewById(R.id.tvData);

        Intent intent = getIntent();
        //Intent에 저장된 데이터 접근 시 get타입명Extra()호출
        //객체가 아닌 기본 데이터 값은 default 값을 적어줘야한다
        //intent.getIntExtra(이름,defaultValue 값):이름이 없으면 0(defaultValue 값으로 지정한)으로 화면에 출력
        tvData.setText(intent.getStringExtra("data")+intent.getIntExtra("num1", 0));


        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondMainActivity.this, FirstMainActivity.class);
                startActivity(intent);
            }
        });
    }
}