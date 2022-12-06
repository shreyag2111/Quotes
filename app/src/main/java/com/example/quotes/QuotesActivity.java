package com.example.quotes;

import static com.example.quotes.R.drawable.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class QuotesActivity extends AppCompatActivity {

    TextView txtQuotes;
    int imgs[] = {img_1, img_2, img_3, img_4, img_5, img_6, img_7, img_8, img_9, img_10,img_11,img_12,img_13,img_14,img_15};
    RecyclerView imaList;
    public static ImageView backImage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        backImage = findViewById(R.id.backImage);
        imaList = findViewById(R.id.imgList);
        txtQuotes = findViewById(R.id.txtQuotes);

        int pos = getIntent().getIntExtra("pos", 0);

        txtQuotes.setText(ListingAdapter.test.get(pos).quotes);

        imaList.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        imaList.setAdapter(new ImageListAdapter(imgs));
    }
}