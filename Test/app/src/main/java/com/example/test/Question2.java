package com.example.test;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Question2 extends AppCompatActivity implements View.OnClickListener{
    Button btnFre, btnNet;
    ImageView img1;
    int cnt = 0;
    int imgArr[] = {R.drawable.mokoko1, R.drawable.mokoko2, R.drawable.mokoko3};
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        btnFre = findViewById(R.id.btnFre);
        btnNet = findViewById(R.id.btnNet);
        img1 = findViewById(R.id.img1);
        btnFre.setOnClickListener(this);
        btnNet.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if(viewId == R.id.btnFre){
            cnt++;
            if(cnt == imgArr.length) {
                cnt = 0;
            }


            img1.setImageResource(imgArr[cnt]);

        }
        else {

            if(cnt == 0) {
                cnt = imgArr.length;
            }
            cnt--;
            img1.setImageResource(imgArr[cnt]);
        }
    }
}