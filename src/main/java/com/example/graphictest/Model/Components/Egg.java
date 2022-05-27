package com.example.graphictest.Model.Components;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Egg extends Rectangle {

    private double speed;

    public Egg() {
        Image image;
        switch (Boss.getInstance().getPhase()) {
            case 2:
                this.setWidth(75);
                this.setHeight(33);
                image = new Image(getClass().getResource("/com/example/graphictest/images/phase2egg.png").toExternalForm());
                this.setFill(new ImagePattern(image));
                this.setX(Boss.getInstance().getX() - 10);
                this.setY(Boss.getInstance().getY() + 60);
                break;
            case 3:
                this.setWidth(44);
                this.setHeight(33);
                image = new Image(getClass().getResource("/com/example/graphictest/images/heart.png").toExternalForm());
                this.setFill(new ImagePattern(image));
                this.setX(Boss.getInstance().getX() + 160);
                this.setY(Boss.getInstance().getY());
                break;
            default:
                this.setWidth(46);
                this.setHeight(58);
                image = new Image(getClass().getResource("/com/example/graphictest/images/egg.png").toExternalForm());
                this.setFill(new ImagePattern(image));
                this.setX(Boss.getInstance().getX() - 10);
                this.setY(Boss.getInstance().getY() + 60);
                break;
        }

        this.speed = 12;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}