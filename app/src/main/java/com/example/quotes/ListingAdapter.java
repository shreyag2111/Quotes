package com.example.quotes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;
public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ListingHolder> {
    public static ArrayList<QuotesData> test;
    Context context;
    public ListingAdapter(ArrayList<QuotesData> test) {
        this.test = test;
    }
    @NonNull
    @Override
    public ListingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ListingHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ListingHolder holder, @SuppressLint("RecyclerView") int position) {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//        view.setBackgroundColor(color);
        holder.cards.setCardBackgroundColor(color);
        holder.txtQuotes.setText(test.get(position).quotes);
        holder.txtQuotes.setTextColor(color);
        holder.txtWriter.setText("- "+test.get(position).writer);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, QuotesActivity.class).putExtra("pos",position));
            }
        });
    }
    @Override
    public int getItemCount() {
        return test.size();
    }
    class ListingHolder extends RecyclerView.ViewHolder {
        TextView txtQuotes, txtWriter;
        CardView cards;
        public ListingHolder(@NonNull View itemView) {
            super(itemView);
            txtQuotes = itemView.findViewById(R.id.txtQuotes);
            txtWriter = itemView.findViewById(R.id.txtWriter);
            cards = itemView.findViewById(R.id.cards);
        }
    }
}
