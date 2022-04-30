package com.example.ex0414;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

//아이템뷰에 배치된 View객체들을 초기화하는 역할
public class ViewHolder {
    private ImageView imageView;
    private TextView tvName;
    private TextView tvPhone;
    private ImageButton btnCall;

    public ViewHolder(View itemview) {
        imageView = itemview.findViewById(R.id.imageView);
        tvName = itemview.findViewById(R.id.tvName);
        tvPhone = itemview.findViewById(R.id.tvPhone);
        btnCall = itemview.findViewById(R.id.btnCall);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTvName() {
        return tvName;
    }

    public TextView getTvPhone() {
        return tvPhone;
    }

    public ImageButton getBtnCall() {
        return btnCall;
    }
}
