package com.example.gem2;

import java.io.Serializable;

public class Masina implements Serializable {
    private int codMasina;
    private String marca;
    private float pret;
    boolean asigurare;
    float rating;

    public Masina(){}

    public Masina(int codMasina, String marca, float pret, boolean asigurare, float rating) {
        this.codMasina = codMasina;
        this.marca = marca;
        this.pret = pret;
        this.asigurare = asigurare;
        this.rating = rating;
    }

    public void setCodMasina(int codMasina) {
        this.codMasina = codMasina;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public void setAsigurare(boolean asigurare) {
        this.asigurare = asigurare;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getCodMasina() {
        return codMasina;
    }

    public String getMarca() {
        return marca;
    }

    public float getPret() {
        return pret;
    }

    public boolean isAsigurare() {
        return asigurare;
    }

    public float getRating() {
        return rating;
    }
}
