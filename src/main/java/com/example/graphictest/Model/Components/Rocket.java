package com.example.graphictest.Model.Components;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Rocket extends Rectangle {

    private double speed;

    public Rocket() {
        this.setWidth(66.5);
        this.setHeight(40);
        this.setX(CupHead.getInstance().getX());
        this.setY(CupHead.getInstance().getY());
        Image image = new Image(getClass().getResource("/com/example/graphictest/images/rocket.png").toExternalForm());
        this.setFill(new ImagePattern(image));
        this.speed = 10;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
