package com.example.animes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Item extends AppCompatActivity {

    TextView titulo;
    TextView desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item2);

        titulo = (TextView) findViewById(R.id.tit);
        desc = (TextView) findViewById(R.id.desc);


        titulo.setText(getIntent().getStringExtra("TITULO"));
        desc.setText(getIntent().getStringExtra("DESC"));
    }
}