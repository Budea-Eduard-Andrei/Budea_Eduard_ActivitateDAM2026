package com.example.problema1_grup;

import java.io.Serializable;

public class Incarcator implements Serializable {
    private String id;
    private String producator;
    private float pret;
    private String tip;

    private String culoare;

    public Incarcator(){}

    public Incarcator(String id, String producator, float pret, String tip, String culoare) {
        this.tip = tip;
        this.culoare = culoare;
        this.id = id;
        this.producator = producator;
        this.pret = pret;
    }

    public String getId() {
        return id;
    }

    public String getProducator() {
        return producator;
    }

    public float getPret() {
        return pret;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", producator: " + producator + ", pret: " + pret ;
    }
}
