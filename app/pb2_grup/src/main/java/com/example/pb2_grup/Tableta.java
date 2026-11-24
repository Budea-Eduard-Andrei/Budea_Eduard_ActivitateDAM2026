package com.example.pb2_grup;

import java.io.Serializable;

public class Tableta implements Serializable {
    private int idTableta;
    private String model;
    private double spatiuMemorie;
    private boolean wirelessCharging;

    public Tableta(){}

    public Tableta(int idTableta, String model, double spatiuMemorie, boolean wirelessCharging) {
        this.idTableta = idTableta;
        this.model = model;
        this.spatiuMemorie = spatiuMemorie;
        this.wirelessCharging = wirelessCharging;
    }

    public void setIdTableta(int idTableta) {
        this.idTableta = idTableta;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpatiuMemorie(double spatiuMemorie) {
        this.spatiuMemorie = spatiuMemorie;
    }

    public void setWirelessCharging(boolean wirelessCharging) {
        this.wirelessCharging = wirelessCharging;
    }

    public int getIdTableta() {
        return idTableta;
    }

    public String getModel() {
        return model;
    }

    public double getSpatiuMemorie() {
        return spatiuMemorie;
    }

    public boolean isWirelessCharging() {
        return wirelessCharging;
    }
}
