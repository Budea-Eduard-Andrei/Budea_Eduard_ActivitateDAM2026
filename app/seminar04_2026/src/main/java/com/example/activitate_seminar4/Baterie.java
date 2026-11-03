package com.example.activitate_seminar4;

import android.os.Parcel;
import android.os.Parcelable;

public class Baterie implements Parcelable {

    private String marca;
    private int capacitate;
    private boolean esteReincarcabila;
    private String putereIncarcare;

    public Baterie(String marca, int capacitate, boolean esteReincarcabila) {
        this.marca = marca;
        this.capacitate = capacitate;
        this.esteReincarcabila = esteReincarcabila;
    }

    protected Baterie(Parcel in) {
        marca = in.readString();
        capacitate = in.readInt();
        esteReincarcabila = in.readByte() != 0;
        putereIncarcare = in.readString();
    }

    public static final Creator<Baterie> CREATOR = new Creator<Baterie>() {
        @Override
        public Baterie createFromParcel(Parcel in) {
            return new Baterie(in);
        }

        @Override
        public Baterie[] newArray(int size) {
            return new Baterie[size];
        }
    };

    public String getMarca() {
        return marca;
    }

    public String getPutereIncarcare() {
        return putereIncarcare;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public boolean isEsteReincarcabila() {
        return esteReincarcabila;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(marca);
        dest.writeInt(capacitate);
        dest.writeByte((byte) (esteReincarcabila ? 1 : 0));
        dest.writeString(putereIncarcare);
    }

    @Override
    public String toString() {
        return "Baterie " + marca + " - Capacitate: " + capacitate + "mAh (Fast charge: " + (esteReincarcabila ? "Da" : "Nu") + ")";
    }
}