package com.example.graphictest.Model.Components;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Bullet extends Rectangle {

    private double speed;

    public Bullet() {
            this.setWidth(36);
            this.setHeight(7.5);
            this.setX(CupHead.getInstance().getX() + CupHead.getInstance().getWidth());
            this.setY(CupHead.getInstance().getY() + (CupHead.getInstance().getHeight() / 2));
            Image image = new Image(getClass().getResource("/com/example/graphictest/images/bullet.png").toExternalForm());
            this.setFill(new ImagePattern(image));
            this.speed = 5;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
