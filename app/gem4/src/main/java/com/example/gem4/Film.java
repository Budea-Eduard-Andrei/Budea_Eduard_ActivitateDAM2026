package com.example.gem4;

import java.io.Serializable;

public class Film implements Serializable {
    private int idFilm;
    private String titlu;
    private float rating;
    private String cinematografe;

    public Film(){}

    public Film(int idFilm, String titlu, float rating, String cinematografe) {
        this.idFilm = idFilm;
        this.titlu = titlu;
        this.rating = rating;
        this.cinematografe = cinematografe;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setCinematografe(String cinematografe) {
        this.cinematografe = cinematografe;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public String getTitlu() {
        return titlu;
    }

    public String getCinematografe() {
        return cinematografe;
    }

    public float getRating() {
        return rating;
    }
}
