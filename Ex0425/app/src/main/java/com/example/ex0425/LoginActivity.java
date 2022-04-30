package com.example.ex0425;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoginActivity extends AppCompatActivity {


    TextView tvName;
    EditText edtUserId, edtUserPw;
    Button btnLogin;

    String[] userIdList = {"smhrd", "mokoko"};
    String[] userPwList = {"1234", "4567"};

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvName = findViewById(R.id.tvName);
        edtUserId = findViewById(R.id.edtUserId);
        edtUserPw = findViewById(R.id.edtUserPw);
        btnLogin = findViewById(R.id.btnLogin);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = edtUserId.getText().toString();
                String pw = edtUserPw.getText().toString();

                for(i = 0; i<userIdList.length; i++) {
                    if(id.equals(userIdList[i]) && pw.equals(userPwList[i])) {

                        Intent intent = new Intent(LoginActivity.this,
                                ChatActivity.class);
                        intent.putExtra("login_id", id);

                        startActivity(intent);

                        break;
                    }

                    if(i==userIdList.length-1) {
                        Toast.makeText(LoginActivity.this,
                                "다시 로그인 해주세요!",
                                Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}