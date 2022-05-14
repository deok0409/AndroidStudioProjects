package com.example.ex0419;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MypageActivity extends AppCompatActivity {

    TextView tvInfo1,tvInfo2,tvInfo3,tvInfo4,tvInfo5,tvInfo6,tvInfo7,tvInfo8,tvInfo9,tvInfo10;

    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        Intent intent = getIntent();

        tvInfo1 = findViewById(R.id.tvInfo1);
        tvInfo2 = findViewById(R.id.tvInfo2);
        tvInfo3 = findViewById(R.id.tvInfo3);
        tvInfo4 = findViewById(R.id.tvInfo4);
        tvInfo5 = findViewById(R.id.tvInfo5);
        tvInfo6 = findViewById(R.id.tvInfo6);
        tvInfo7 = findViewById(R.id.tvInfo7);
        tvInfo8 = findViewById(R.id.tvInfo8);
        tvInfo9 = findViewById(R.id.tvInfo9);
        tvInfo10 = findViewById(R.id.tvInfo10);
        queue = Volley.newRequestQueue(MypageActivity.this);


        //User user = UserInfo.info;


    }
}