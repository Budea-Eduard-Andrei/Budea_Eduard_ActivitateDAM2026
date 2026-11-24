package com.example.gem3;

import java.io.Serializable;

public class Zbor implements Serializable {
    private int idZbor;
    private String destinatie;
    private float pretBilet;
    private boolean includeCazare;

    public Zbor(){}

    public Zbor(int idZbor, String destinatie, float pretBilet, boolean includeCazare) {
        this.idZbor = idZbor;
        this.destinatie = destinatie;
        this.pretBilet = pretBilet;
        this.includeCazare = includeCazare;
    }

    public int getIdZbor() {
        return idZbor;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public float getPretBilet() {
        return pretBilet;
    }

    public boolean isIncludeCazare() {
        return includeCazare;
    }

    public void setIdZbor(int idZbor) {
        this.idZbor = idZbor;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public void setPretBilet(float pretBilet) {
        this.pretBilet = pretBilet;
    }

    public void setIncludeCazare(boolean includeCazare) {
        this.includeCazare = includeCazare;
    }
}
