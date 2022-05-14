package com.example.ex0430;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Fragment3 extends Fragment {

    EditText edtUrl;
    Button btnSave;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment3() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        edtUrl = view.findViewById(R.id.edtUrl);
        btnSave = view.findViewById(R.id.btnSave);
        //SharedPreferences : 엡의 데이터를 저장하기 위한 객체
        //: 간단한 데이터를 key, value 형태로 저장 -> 안드로이드 내부에 XML 파일로 저장
        // Context.MODE_PRIVATE : 외부 앱에서 접근 불가 하는 설정 값
        SharedPreferences spf = getActivity().getSharedPreferences("mySPF",
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = spf.edit();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //사용자가 Url 값을 입력하면 저장
                String url = edtUrl.getText().toString();
                //url 값을 mySPF.xml 파일에 url 값을 저장
                editor.putString("url", url);
                editor.commit();
                //getActivity() --> MainActivity
                Toast.makeText(getActivity(), "새로운 주소가 설정되었습니다!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}