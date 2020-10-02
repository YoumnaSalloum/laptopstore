package com.example.laptopstore;

import java.util.ArrayList;

public class lap {
    String name;
    int img;
    String lap_de;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getLap_de() {
        return lap_de;
    }

    public void setLap_de(String lap_de) {
        this.lap_de = lap_de;
    }
/*  public lap(String[] name, int[] img) {
        this.name = name;
        this.img = img;
    }
*/

    public lap(String name, int img, String lap_de) {
        this.name = name;
        this.img = img;
        this.lap_de=lap_de;
    }
}
