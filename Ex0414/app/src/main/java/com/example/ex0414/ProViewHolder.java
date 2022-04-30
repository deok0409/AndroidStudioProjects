package com.example.ex0414;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProViewHolder {

    private ImageView imageView2;
    private TextView pro_name;
    private TextView pro_count;
    private Button btnSv;

    public ProViewHolder(View itemview) {
        this.imageView2 = itemview.findViewById(R.id.imageView2);
        this.pro_name = itemview.findViewById(R.id.pro_name);
        this.pro_count = itemview.findViewById(R.id.pro_count);
        this.btnSv = itemview.findViewById(R.id.btnSv);
    }

    public ImageView getImageView2() {
        return imageView2;
    }

    public void setImageView2(ImageView imageView2) {
        this.imageView2 = imageView2;
    }

    public TextView getPro_name() {
        return pro_name;
    }

    public void setPro_name(TextView pro_name) {
        this.pro_name = pro_name;
    }

    public TextView getPro_count() {
        return pro_count;
    }

    public void setPro_count(TextView pro_count) {
        this.pro_count = pro_count;
    }

    public Button getBtnSv() {
        return btnSv;
    }

    public void setBtnSv(Button btnSv) {
        this.btnSv = btnSv;
    }
}
