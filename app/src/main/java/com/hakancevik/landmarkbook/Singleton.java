package com.hakancevik.landmarkbook;

import com.hakancevik.landmarkbook.model.Landmark;

public class Singleton {

    private Landmark selectedLandmark;
    private static Singleton singleton;

    private Singleton() {

    }

    public Landmark getSelectedLandmark() {
        return selectedLandmark;
    }

    public void setChosenLandmark(Landmark selectedLandmark) {
        this.selectedLandmark = selectedLandmark;
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;

    }

}