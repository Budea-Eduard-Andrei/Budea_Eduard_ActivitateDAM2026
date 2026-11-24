package com.example.rezolvare_singur;

import java.io.Serializable;



public class Cutie implements Serializable {
    private String cod;
    private String culoare;
    private double volum;
    private boolean esteFragil;

    private float rating;

    Cutie(){

    }

    public Cutie(String cod, String culoare, double volum, boolean esteFragil, float rating) {
        this.cod = cod;
        this.culoare = culoare;
        this.volum = volum;
        this.esteFragil = esteFragil;
        this.rating = rating;
    }

    public String getCod() {
        return cod;
    }

    public String getCuloare() {
        return culoare;
    }

    public double getVolum() {
        return volum;
    }

    public boolean isEsteFragil() {
        return esteFragil;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public void setVolum(double volum) {
        this.volum = volum;
    }

    public void setEsteFragil(boolean esteFragil) {
        this.esteFragil = esteFragil;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Cod: " + cod + ", volum" + volum + ", culoare" + culoare;
    }
}
