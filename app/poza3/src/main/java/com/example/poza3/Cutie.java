package com.example.poza3;

import java.io.Serializable;

public class Cutie implements Serializable {
    private int cod;
    private String culoare;
    private double volum;
    private boolean esteFragila;
    private float rating;

    public Cutie(){}

    public Cutie(int cod, String culoare, double volum, boolean esteFragila, float rating) {
        this.cod = cod;
        this.culoare = culoare;
        this.volum = volum;
        this.esteFragila = esteFragila;
        this.rating = rating;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public void setVolum(double volum) {
        this.volum = volum;
    }

    public void setEsteFragila(boolean esteFragila) {
        this.esteFragila = esteFragila;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getCod() {
        return cod;
    }

    public String getCuloare() {
        return culoare;
    }

    public double getVolum() {
        return volum;
    }

    public boolean isEsteFragila() {
        return esteFragila;
    }

    public float getRating() {
        return rating;
    }
}
