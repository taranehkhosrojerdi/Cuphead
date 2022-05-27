package com.example.graphictest.Model.Components;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class MiniBoss extends Rectangle {

    private int speed;
    private double hearts;

    public MiniBoss() {
        this.setX(721);
        this.setY(280);
        this.setWidth(95.4);
        this.setHeight(65.4);
        this.speed = 3;
        this.hearts = 1;
    }


    public int getSpeed() {
        return speed;
    }

    public double getHearts() {
        return hearts;
    }

    public void setHearts(double hearts) {
        this.hearts = hearts;
    }

    public void setFlyImage(int frame) {
        if (frame == 5) frame--;
        Image image = new Image(getClass().getResource("/com/example/graphictest/MiniBossFly/yellow/" + frame + ".png").toExternalForm());
        this.setFill(new ImagePattern(image));
    }

}