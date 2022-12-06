package com.example.quotes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ListingHolder> {
    public static int[] test;
    Context context;

    public ImageListAdapter(int[] test) {
        this.test = test;
    }

    @NonNull
    @Override
    public ListingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_item, parent, false);
        return new ListingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListingHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(test[position]).into(holder.imgItem);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(context).load(test[position]).into(QuotesActivity.backImage);
            }
        });
    }

    @Override
    public int getItemCount() {
        return test.length;
    }

    class ListingHolder extends RecyclerView.ViewHolder {
        ImageView imgItem;

        public ListingHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
        }
    }
}
