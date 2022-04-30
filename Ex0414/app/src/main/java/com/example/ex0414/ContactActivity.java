package com.example.ex0414;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    ListView lvContact;
    ContactAdapter adapter;
    ArrayList<ContactVO> list;
    int i;
    //int[] imgArr = {R.drawable.mia,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        lvContact = findViewById(R.id.lvContact);
        list = new ArrayList<ContactVO>();

        for(i = 0; i < 20; i++) {
            list.add(new ContactVO(
                    R.drawable.mia,
                    "백정미아"+(i+1),
                    "010-1234-5678")
            );
        }

        adapter = new ContactAdapter(ContactActivity.this,
                R.layout.list_item,
                list
        );

        lvContact.setAdapter(adapter);
    }
}