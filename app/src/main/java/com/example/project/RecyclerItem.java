package com.example.project;

public class RecyclerItem {
    private String name;
    private int distanceFromSun;
    private int size;
    private int moonCount;

    public RecyclerItem(String name, int distanceFromSun, int size, int moonCount) {
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

    public int getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(int distanceFromSun) {
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

}
