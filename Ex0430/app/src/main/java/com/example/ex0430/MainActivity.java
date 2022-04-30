package com.example.ex0430;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView botNav;
    Fragment1 frag_home;
    Fragment2 frag_time;
    Fragment3 frag_setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botNav = findViewById(R.id.botNav);

        frag_home = new Fragment1();
        frag_time = new Fragment2();
        frag_setting = new Fragment3();

        //실행 시 처음에 보여줄 Fragment 화면 설정
        //replace(Fragment 를 보여주는 레이아웃 리소스 ID ,보여줄 Fragment 객체)
        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_home).commit();

        botNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //선택한 메뉴버튼에 대한 리소스ID 저장
                int itemId = item.getItemId();

                if(itemId == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_home).commit();
                }
                else if(itemId == R.id.time) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_time).commit();
                }
                else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_setting).commit();
                }

                return false;
            }
        });


    }
}