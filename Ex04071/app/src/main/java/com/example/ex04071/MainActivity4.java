package com.example.ex04071;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener{
    ImageView img;
    Button btnigChange1, btnigChange2;
    int[] imgArr = {R.drawable.pm1,R.drawable.pm2,R.drawable.pm3};
    int cnt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        img = findViewById(R.id.img);
        btnigChange1 = findViewById(R.id.btnigChange1);
        btnigChange2 = findViewById(R.id.btnigChange2);

        btnigChange1.setOnClickListener(this);
        btnigChange2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if(viewId == R.id.btnigChange2){
            cnt++;
            if(cnt == imgArr.length) {
                cnt = 0;
            }


            img.setImageResource(imgArr[cnt]);

        }
        else {

            if(cnt == 0) {
                cnt = imgArr.length;
            }
            cnt--;
            img.setImageResource(imgArr[cnt]);
        }
    }
}