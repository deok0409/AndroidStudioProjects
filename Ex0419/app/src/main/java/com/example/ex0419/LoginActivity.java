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

public class LoginActivity extends AppCompatActivity {

    EditText edtId, edtPw;
    Button btnLogin, btnJoin;

    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtId = findViewById(R.id.edtId);
        edtPw = findViewById(R.id.edtPw);
        btnLogin = findViewById(R.id.btnLogin);
        btnJoin = findViewById(R.id.btnJoin);

        queue = Volley.newRequestQueue(LoginActivity.this);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);

                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int method = Request.Method.POST;
                String server_url = "http://192.168.88.1:8081/android/Login";

                request = new StringRequest(
                        method,
                        server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(LoginActivity.this,
                                        "Login Success"+" "+response,
                                        Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(LoginActivity.this,
                                        "Login Fail"+error.toString(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                ){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> param = new HashMap<>();
                        param.put("id", edtId.getText().toString());
                        param.put("pw", edtPw.getText().toString());

                        return param;
                    }
                };

                queue.add(request);
            }
        });
    }
}