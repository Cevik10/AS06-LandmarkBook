package com.hakancevik.landmarkbook.model;

import java.io.Serializable;

public class Landmark implements Serializable {

    public String name;
    public String country;
    public int image;

    public Landmark(String name, String country, int image) {
        this.name = name;
        this.country = country;
        this.image = image;
    }
}
