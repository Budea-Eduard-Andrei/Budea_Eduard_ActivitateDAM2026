package com.example.gem;

import android.view.LayoutInflater;

import java.io.Serializable;

public class Laptop implements Serializable {
    private int idLaptop;
    private String procesor;
    private float pret;
    private boolean sustineGaming;

    public Laptop(){}

    public Laptop(int idLaptop, String procesor, float pret, boolean sustineGaming) {
        this.idLaptop = idLaptop;
        this.procesor = procesor;
        this.pret = pret;
        this.sustineGaming = sustineGaming;
    }

    public void setIdLaptop(int idLaptop) {
        this.idLaptop = idLaptop;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public void setSustineGaming(boolean sustineGaming) {
        this.sustineGaming = sustineGaming;
    }

    public int getIdLaptop() {
        return idLaptop;
    }

    public String getProcesor() {
        return procesor;
    }

    public float getPret() {
        return pret;
    }

    public boolean isSustineGaming() {
        return sustineGaming;
    }
}
