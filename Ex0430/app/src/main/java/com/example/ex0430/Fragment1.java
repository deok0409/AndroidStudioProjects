package com.example.ex0430;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Fragment1 extends Fragment {

    WebView webView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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

        View view = inflater.inflate(R.layout.fragment_1, container, false);

        webView = view.findViewById(R.id.webView);
        //getSharedPreferences에 저장된 데이터 접근
        String url = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE)
                .getString("url", "https://www.smhrd.or.kr");

        //안드로이드에 설치되어 있는 기본 브라우저를 실행  -->
        //WebSettings 객체를 이용해서 WebView에 바로 띄워지도록 설정
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true); //자바스크립트 사용허용

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        return view;
    }
}