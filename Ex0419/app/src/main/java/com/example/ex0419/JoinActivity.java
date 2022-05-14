package com.example.ex0419;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class JoinActivity extends AppCompatActivity {

    EditText edtJoinId, edtJoinPw, edtNick, edtEmail, edtPhone, edtAddr;
    Button btnSuccess;

    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        edtJoinId = findViewById(R.id.edtJoinId);
        edtJoinPw = findViewById(R.id.edtJoinPw);
        edtNick = findViewById(R.id.edtNick);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        edtAddr = findViewById(R.id.edtAddr);
        btnSuccess = findViewById(R.id.btnSuccess);

        queue = Volley.newRequestQueue(JoinActivity.this);

        btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int method = Request.Method.POST;
                String server_url = "http://192.168.88.1:8081/myapp/Join";

                request = new StringRequest(
                        method,
                        server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(JoinActivity.this,
                                        "요청성공!",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);

                                startActivity(intent);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(JoinActivity.this,
                                        "요청실패>>" + error.toString(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                ) {
                    //★★★POST 방식으로 데이터를 전송할 때 사용하는 메소드★★★
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        //key 와 value 형태로 데이터를 저장하는 자료구조 ->> Map
                        Map<String, String> param = new HashMap<>();

                        param.put("user_id", edtJoinId.getText().toString());
                        param.put("user_pw", edtJoinPw.getText().toString());
                        param.put("user_nick", edtNick.getText().toString());
                        param.put("user_email", edtEmail.getText().toString());
                        param.put("user_phone", edtPhone.getText().toString());
                        param.put("user_addr", edtAddr.getText().toString());
                        return param;
                    }
                };//end

                queue.add(request);
            }
        });
    }
}