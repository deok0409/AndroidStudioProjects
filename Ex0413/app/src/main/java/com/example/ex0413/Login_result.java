package com.example.ex0413;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Login_result extends AppCompatActivity {
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        tvResult = findViewById(R.id.tvResult);

        Intent intent = getIntent();
        String email = intent.getStringExtra("edtEmail");
        String pw = intent.getStringExtra("edtPw");

        if(email.equals("smhrd") && pw.equals("1234")) {
            tvResult.setText("로그인 성공!");
        }
        else {
            tvResult.setText("로그인 실패!");
        }


    }
}