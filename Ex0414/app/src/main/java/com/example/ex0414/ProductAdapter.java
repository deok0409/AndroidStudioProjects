package com.example.ex0414;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<ProductVO> list;
    LayoutInflater inflater;

    public ProductAdapter(Context context, int layout, ArrayList<ProductVO> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ProViewHolder holder = null;

        if(view == null) {
            view = inflater.inflate(layout, viewGroup, false);
            holder = new ProViewHolder(view);
            view.setTag(holder);
        }

        else {
            holder = (ProViewHolder) view.getTag();
        }

        ProductVO vo = (ProductVO) getItem(i);
        holder.getImageView2().setImageResource(vo.getImg());
        holder.getPro_name().setText(vo.getPro_name());
        holder.getPro_count().setText(vo.getPro_count());

        holder.getBtnSv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //대화상자: AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle("상품보기")
                        .setMessage("상품개수:")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }

                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
            }


        return view;
    }
}
