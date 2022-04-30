package com.example.ex0414;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button btnFt;
    EditText edtFt;
    ListView lv;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        btnFt = findViewById(R.id.btnFt);
        edtFt = findViewById(R.id.edtFt);
        list = new ArrayList<String>();

        list.add("사과");
        list.add("배");
        list.add("딸기");
        list.add("포도");
        list.add("수박");
        list.add("오렌지");
        list.add("감");
        list.add("망고");
        list.add("용과");
        list.add("파인애플");
        list.add("키위");
        list.add("귤");
        list.add("참외");
        list.add("거봉");

        //new ArrayAdapter(recent activityname.this, layout, data)
        //layout :  show itemView from listView
        //data : output in itemView
        adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                list
        );

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //adapterView : 클릭이 일어난 adapterView
                //view : 클릭한 아이템뷰를 View객체로 반환
                //l,i : 클릭한 아이템뷰의 행 인덱스를 반환

                String data = list.get(i);
                Toast.makeText(MainActivity.this, "선택한 항목 : "+ data, Toast.LENGTH_SHORT).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, "롱클릭!", Toast.LENGTH_SHORT).show();

                String fruit = list.get(i);
                adapter.remove(fruit);

                return false;
            }
        });

        //버튼을 클릭했을 때 listView에 데이터 저장
        btnFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                String fruit = edtFt.getText().toString();
                adapter.add(fruit);
                //list.add(fruit);

                //어뎁터에 데이터 추가 후 listView 업데이트하는 메소드드
                //adapter의 update된 내용을 갱신 시켜줌
                //adapter.notifyDataSetChanged();
                
            }
        });

    }
}