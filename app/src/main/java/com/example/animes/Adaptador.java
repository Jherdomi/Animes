package com.example.animes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private ArrayList<Entidad> listItem;
    private Context context;

    public Adaptador(Context context, ArrayList<Entidad> listItem) {
        this.listItem = listItem;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        Entidad item = (Entidad) getItem(i);

        view = LayoutInflater.from(context).inflate(R.layout.item, null);
        ImageView imgFoto = view.findViewById(R.id.foto);
        TextView TW = view.findViewById(R.id.titulo);
        RatingBar ratingBar = view.findViewById(R.id.valoracion);
        ratingBar.setEnabled(false);

        imgFoto.setImageResource(item.getImgFoto());
        TW.setText(item.getTitulo());
        ratingBar.setRating(item.getValoracion());

        return view;
    }
}
