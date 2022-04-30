package com.example.ex0413;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class kakao_login extends AppCompatActivity {
    EditText edtEmail, edtPw;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPw = findViewById(R.id.edtPw);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data1 = edtEmail.getText().toString();
                String data2 = edtPw.getText().toString();

                Intent intent = new Intent(kakao_login.this, Login_result.class);

                intent.putExtra("edtEmail", data1);
                intent.putExtra("edtPw", data2);

                startActivity(intent);
            }
        });
    }
}