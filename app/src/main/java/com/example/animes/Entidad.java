package com.example.animes;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RatingBar;

import androidx.annotation.NonNull;

public class Entidad implements Parcelable {

    private int imgFoto;
    private String titulo;
    private Float valoracion;

    private String desc;

    public Entidad(int imgFoto, String titulo, Float valoracion, String desc) {
        this.imgFoto = imgFoto;
        this.titulo = titulo;
        this.valoracion = valoracion;
        this.desc = desc;
    }

    protected Entidad(Parcel in) {
        imgFoto = in.readInt();
        titulo = in.readString();
        if (in.readByte() == 0) {
            valoracion = null;
        } else {
            valoracion = in.readFloat();
        }
        desc = in.readString();
    }

    public static final Creator<Entidad> CREATOR = new Creator<Entidad>() {
        @Override
        public Entidad createFromParcel(Parcel in) {
            return new Entidad(in);
        }

        @Override
        public Entidad[] newArray(int size) {
            return new Entidad[size];
        }
    };

    public int getImgFoto() {
        return imgFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public Float getValoracion() {
        return valoracion;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(imgFoto);
        parcel.writeString(titulo);
        if (valoracion == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeFloat(valoracion);
        }
        parcel.writeString(desc);
    }
}
