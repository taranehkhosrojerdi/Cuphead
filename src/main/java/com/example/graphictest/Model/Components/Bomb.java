package com.example.graphictest.Model.Components;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Bomb extends Rectangle {

    private double speed;

    public Bomb() {
        this.setWidth(22.5);
        this.setHeight(18);
        this.setX(CupHead.getInstance().getX() + (CupHead.getInstance().getWidth() / 2));
        this.setY(CupHead.getInstance().getY() + CupHead.getInstance().getHeight());
        Image image = new Image(getClass().getResource("/com/example/graphictest/images/bomb.png").toExternalForm());
        this.setFill(new ImagePattern(image));
        this.speed = 7;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
