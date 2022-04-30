package com.example.ex0428;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    TextView tvNum, tvNum2;
    Button btnStart, btnStart2;
    int i, cnt1, cnt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNum = findViewById(R.id.tvNum);
        tvNum2 = findViewById(R.id.tvNum2);
        btnStart = findViewById(R.id.btnStart);
        btnStart2 =findViewById(R.id.btnStart2);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Thread 객체생성
                TimerThread thread = new TimerThread(tvNum);
                //Thread 실행
                thread.start();

                btnStart.setEnabled(false);
            }
        });

        btnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimerThread2 thread2 = new TimerThread2(tvNum2);

                thread2.start();

                btnStart2.setEnabled(false);
            }
        });


    }

    //Thread(스레드)
    // 하나의 프로세스 내에서 작업을 처리하는 작은 단위
    // Main Thread 이외에 작업을 별도로 처리할 때 활용

    //Main Thread의 역할
    // UI를 업데이트하는 역할

    class TimerThread extends Thread{

        TimerHandler handler = new TimerHandler();
        TextView tv;

        public TimerThread(TextView tv) {
            this.tv = tv;
        }

        @Override
        public void run() {
            //실행할 로직 정의
            for(i = 0; i < 10; i++) {
                Log.d("TimerThread", "cnt1 : "+(i+1));

                //tvNum.setText(String.valueOf(i+1));
                //Handler 에 값을 전달 -> Message 객체를 전달
                Message msg = new Message();
                msg.arg1 = i + 1;
                msg.obj = tv; // TextView -> Object 로 업캐스팅되서 저장
                // Message 객체 전송
                handler.sendMessage(msg);


            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
          }
        }
    }// end class

    class TimerHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            //Sub Thread 에서 처리한 결과를 UI 업데이트 할 때
            //handlerMessage() 안에 정의
            int cnt1 = msg.arg1;
            TextView tv = (TextView)msg.obj; // Object 타입으로 저장된 TextView 객체를 다운캐스팅
            //tvNum.setText(String.valueOf(cnt1));

            //TimerThread 객체생성 시 넘겨받은 TextView 객체에 내용을 업데이트
            tv.setText(String.valueOf(cnt1));

        }
    }

    class TimerThread2 extends Thread {

        TimerHandler2 handler2 = new TimerHandler2();
        TextView tv2;

        public TimerThread2(TextView tv2) {
            this.tv2 = tv2;
        }
        @Override
        public void run() {
            for(i = 0; i < 10; i++) {
                Log.d("TimerThread2", "cnt2 : " +(i+1));

                Message msg = new Message();
                msg.arg1 = i + 1;
                msg.obj = tv2;
                handler2.sendMessage(msg);

                try {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }//end

    class TimerHandler2 extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            int cnt2 = msg.arg1;
            TextView tv2 = (TextView)msg.obj;
            //tvNum2.setText(String.valueOf(cnt2));
            tv2.setText(String.valueOf(cnt2));

        }

    }

}