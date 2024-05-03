package com.example.project;

import com.google.gson.annotations.SerializedName;

public class RecyclerItem {
    private String name;
    private String category;
    @SerializedName("location")
    private String distanceFromSun;
    private int size;
    @SerializedName("cost")
    private int moonCount;
    private Auxdata auxdata;



    public RecyclerItem(String name, String distanceFromSun, int size, int moonCount) {
        this.name = name;
        this.distanceFromSun = distanceFromSun;
        this.size = size;
        this.moonCount = moonCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(String distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMoonCount() {
        return moonCount;
    }

    public void setMoonCount(int moonCount) {
        this.moonCount = moonCount;
    }

    public String getCategory() {
        return category;
    }

    public Auxdata getAuxdata() {
        return auxdata;
    }
}
