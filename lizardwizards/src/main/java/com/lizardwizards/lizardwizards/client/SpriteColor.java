package com.lizardwizards.lizardwizards.client;

import javafx.scene.paint.Paint;

import java.io.Serializable;

public class SpriteColor implements Serializable {
    public double red;
    public double green;
    public double blue;
    public double opacity;

    public SpriteColor(double red, double green, double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.opacity = 1.0;
    }

    public SpriteColor(double red, double green, double blue, double opacity) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.opacity = opacity;
    }
}
