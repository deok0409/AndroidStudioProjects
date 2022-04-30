package com.example.ex0406;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//인터페이스 구현을 통해 이벤트 적용
// : 유사한 기능을 구현할 때 사용
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvMsg;
    EditText edtMsg;
    Button btnBgChange;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setContentView()로 UI화면이 생성된 이후에
        //findViewById() 메소드를 사용하여 View의 id값을 참조할 수 있다!
        layout = findViewById(R.id.layout2);
        tvMsg = findViewById(R.id.tvMsg);
        edtMsg = findViewById(R.id.edtMsg);
        Button btnChange = findViewById(R.id.btnChange);
        btnBgChange = findViewById(R.id.btnBgChange);

        //TextView의 text값 접근 -> Log.d()를 활용하여 출력
        //출력결과: Logcat창 or Run창
        //Log 활용: 결과값 확인, 서버통신 데이터 확인
        Log.d("MainActivity_tvMsg", tvMsg.getText().toString());

        //onClick() 가 동작되도록 Button객체에 이벤트 설정
        //this: OnClickListener를 구현한 MainActivity를 가리킴
        btnChange.setOnClickListener(this);
        btnBgChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //이번트가 발생한 view의 id값을 변수에 저장
        int viewId = view.getId();

        //텍스트 변경 버튼일경우
        if(viewId == R.id.btnChange){
            //클릭이벤트 발생 시 동작할 로직 구현
            Log.d("MainActivity_event", "클릭이벤트발생!");

            //EditText에 입력된 내용을 TextView에 설정
            //1.EditText에 입력된 텍스트 가져오기
            String msg = edtMsg.getText().toString();

            //2.TextView에 설정
            tvMsg.setText(msg);
        }
        //배경색 변경 버튼일경우
        else{
            Log.d("MainActivity_event", "클릭이벤트발생!");
            layout.setBackgroundColor(Color.parseColor("#559E37D1"));
        }

    }
}