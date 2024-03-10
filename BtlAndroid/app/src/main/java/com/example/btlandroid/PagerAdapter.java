package com.example.btlandroid;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class PagerAdapter extends RecyclerView.Adapter<PagerAdapter.PhimViewHolder> {
    private ArrayList<String> khuvuc;
    private boolean[] isSelected;
    private OnItemClickListener listener; // Khai báo một Interface

    public interface OnItemClickListener {
        void onItemClick(String item,int position);
    }

    public PagerAdapter( ArrayList<String> khuvuc, OnItemClickListener listener) {
        this.listener = listener;
        this.khuvuc = khuvuc;
        isSelected = new boolean[khuvuc.size()];
        isSelected[0] = true;
    }

    @NonNull
    @Override
    public PagerAdapter.PhimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_phim, parent, false);

        return new PhimViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PagerAdapter.PhimViewHolder holder, int position) {
        String name = khuvuc.get(position);
        holder.khuvucTextView.setText(name);

        if(isSelected[position]){
            holder.khuvucTextView.setTextColor(Color.GREEN);
            holder.itemView.setBackgroundResource(R.drawable.default_background);
        }else{
            holder.khuvucTextView.setTextColor(Color.WHITE);
            holder.itemView.setBackgroundResource(R.drawable.edit_text_background);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onItemClick(name,position);
                    // Đặt tất cả các phần tử về trạng thái không được chọn
                    Arrays.fill(isSelected, false);

                    // Đặt phần tử hiện tại được click vào trạng thái được chọn
                    isSelected[position] = true;
                    notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public int getItemCount() {

        return khuvuc.size();
    }
    public static class PhimViewHolder extends RecyclerView.ViewHolder {
        public TextView khuvucTextView;

        public PhimViewHolder(View itemView) {
            super(itemView);
            khuvucTextView = itemView.findViewById(R.id.frangment_tv);
        }
    }

}
