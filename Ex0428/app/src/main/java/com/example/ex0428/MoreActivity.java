package com.example.ex0428;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.Random;

public class MoreActivity extends AppCompatActivity {

    TextView  tvTime2,  tvCatch2;
    ImageView[] moreArr = new ImageView[9];
    int cnt2;
    int cnt = 0;
    boolean isPlaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        TimerThread3 t_thread = new TimerThread3();
        t_thread.start();

        tvTime2 = findViewById(R.id.tvTime2);
        tvCatch2 = findViewById(R.id.tvCatch2);

        //동적으로 리소스 id 접근 후 ImageView 초기화
        for(int i = 0; i < moreArr.length; i++) {
            final int pos = i;
            //img1~img9 까지의 리소스 id 접근
            int resId = getResources().getIdentifier("img"+(i+1),
                    "id",
                    getPackageName());
            moreArr[i] = findViewById(resId);

            //imageView 에 tag 설정
            //tag : View 에 대한 상태값 저장
            moreArr[i].setTag("down");

            MoreMoveThread thread = new MoreMoveThread(i);
            thread.start();



            //두더지(ImageView)를 클릭 했을 때
            moreArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MoreActivity.this,
                            "kill kimsaja",
                            Toast.LENGTH_SHORT).show();



                    String status = moreArr[pos].getTag().toString();
                    //int cnt1 = Integer.parseInt(tvCatch2.getText().toString());

                    if(status.equals("up")) {
                        cnt++;

                    }
                    else {
                        if(cnt > 0) {
                            cnt--;
                        }
                    }
                    tvCatch2.setText(String.valueOf(cnt));
                }
            });

        }


    }//end

    class MoreMoveThread extends Thread{

        MoreMoveHandler handler = new MoreMoveHandler();
        int more_pos;

        public MoreMoveThread(int more_pos) {
            this.more_pos = more_pos;
        }
        @Override
        public void run() {

            Random ran = new Random();
            //두더지가 위/아래 머물러 있는 시간을 랜덤으로 생성하시오.

            while (isPlaying) {
                int downTime = ran.nextInt(1500)+500;
                int upTime = ran.nextInt(1500)+500;
                //아래 머물러 있는 시간
                try {
                    Thread.sleep(downTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //저장해야 할 데이터 : 두더지 번호, 변경할 두더지 이미지, 두더지 상태
                Message msg = new Message();
                msg.arg1 = more_pos;
                msg.arg2 = R.drawable.up;
                msg.obj = "up";
                handler.sendMessage(msg);

                //위에 머물러 있는 시간
                try {
                    Thread.sleep(upTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                msg = new Message();
                msg.arg1 = more_pos;
                msg.arg2 = R.drawable.down;
                msg.obj = "down";
                handler.sendMessage(msg);
            }//end while
        }
    }

    class MoreMoveHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {

            int pos = msg.arg1;
            int img = msg.arg2;
            String status = (String)msg.obj;

            moreArr[pos].setImageResource(img);
            moreArr[pos].setTag(status); // up/down 상태값 저장
        }
    }//end

    class TimerThread3 extends Thread{

        TimerHandler3 handler3 = new TimerHandler3();

        @Override
        public void run() {
            for(int i = 30; i > -1; i--) {
//                Log.d("TimerThread3", "cnt2 : " + (i));

                Message msg = new Message();
                msg.arg1 = i;
                handler3.sendMessage(msg);

                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }//end ThreadHandler3

    class TimerHandler3 extends Handler{

        @Override
        public void handleMessage(@NonNull Message msg) {
            cnt2 = msg.arg1;
            tvTime2.setText(String.valueOf(cnt2));

            if(cnt2 == 0) {
                isPlaying = false;
            }
        }
    }
}