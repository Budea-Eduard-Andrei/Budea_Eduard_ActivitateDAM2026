package com.example.activitate_seminar4;

import java.io.Serializable;

public class Baterie implements Serializable {
    private String marca;
    private int capacitate;
    private boolean esteReincarcabila;

    private String putereIncarcare;

    public Baterie(String marca, int capacitate, boolean esteReincarcabila) {
        this.marca = marca;
        this.capacitate = capacitate;
        this.esteReincarcabila = esteReincarcabila;
    }

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

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public void setPutereIncarcare(String putereIncarcare) {
        this.putereIncarcare = putereIncarcare;
    }

    public void setEsteReincarcabila(boolean esteReincarcabila) {
        this.esteReincarcabila = esteReincarcabila;
    }

    @Override
    public String toString() {
        return "Baterie " + marca + " - Capacitate: " + capacitate + "mAh (Fast charge: " + (esteReincarcabila ? "Da" : "Nu") + ")";
    }

}
