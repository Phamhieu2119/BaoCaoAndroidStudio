package com.example.btlandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class viewAdapter extends RecyclerView.Adapter<viewAdapter.phimViewHolder> {

    private ArrayList<Phim> movies;
    private Context context;

    public viewAdapter(ArrayList<Phim> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public viewAdapter.phimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_kho_phim,parent,false);
        return new phimViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewAdapter.phimViewHolder holder, int position) {
        Phim movie = movies.get(position);
        holder.textView.setText(movie.getTenPhim());
        Picasso.get().load(movie.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {

        return movies.size();
    }

    public class phimViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public phimViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_kp);
            textView = itemView.findViewById(R.id.textView_kp);

        }
    }
}
