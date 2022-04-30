package com.example.ex04071;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity5 extends AppCompatActivity {
    ImageView dice1, dice2;
    Button button1;
    TextView tvMs1,tvMs2;
    Random ran = new Random();
    int[] imgArr2 = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
    int cnt1, cnt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        tvMs1 = findViewById(R.id.tvMs1);
        tvMs2 = findViewById(R.id.tvMs2);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int viewId = view.getId();
                int num1 = ran.nextInt(6);
                int num2 = ran.nextInt(6);
                dice1.setImageResource(imgArr2[num1]);
                dice2.setImageResource(imgArr2[num2]);

               if(num1 > num2) {
                   Toast.makeText(MainActivity5.this, "dice1승리", Toast.LENGTH_SHORT).show();
                   cnt1++;

               }
               else if(num1 < num2){
                   Toast.makeText(MainActivity5.this, "dice2승리", Toast.LENGTH_SHORT).show();
                   cnt2++;
               }

               tvMs2.setText(cnt1+" : "+cnt2);
            }
        });

    }
}