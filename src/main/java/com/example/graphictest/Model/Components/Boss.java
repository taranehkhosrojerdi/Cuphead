package com.example.graphictest.Model.Components;

import com.example.graphictest.View.SettingsMenu;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Boss extends Rectangle {

    private int speed;
    private double hearts;
    private final boolean isDevil;
    private int phase;

    private static Boss instance;
    public static Boss getInstance() {
        if (instance == null)
            instance = new Boss();
        return instance;
    }

    private Boss() {
        this.setX(420);
        this.setY(70);
        this.setWidth(260.4);
        this.setHeight(203.6);
        this.speed = 1;
        this.hearts = 15;
        isDevil = (SettingsMenu.getDifficultyLevel() == 4);
        phase = 1;
    }

    public void setFlyImage(int frame) {
        if (frame == 7) frame--;
        Image image = new Image(getClass().getResource("/com/example/graphictest/BossFly/" + frame + ".png").toExternalForm());
        this.setFill(new ImagePattern(image));
    }

    public void switchToPhase2() {
        this.setWidth(142.5);
        this.setHeight(176.25);
        phase = 2;
    }

    public void switchToPhase3() {
        this.setY(240);
        this.setWidth(270.9);
        this.setHeight(100.2);
        phase = 3;
    }

    public void setPhase2FlyImage(int frame) {
        if (frame == 14) frame--;
        Image image = new Image(getClass().getResource("/com/example/graphictest/bossPhase2Fly/" + frame + ".png").toExternalForm());
        this.setFill(new ImagePattern(image));
    }

    public void setPhase3FlyImage(int frame) {
        if (frame == 17) frame--;
        Image image = new Image(getClass().getResource("/com/example/graphictest/bossPhase3Fly/" + frame + ".png").toExternalForm());
        this.setFill(new ImagePattern(image));
    }

    public void setShootImage(int frame) {
        if (frame == 13) frame--;
        Image image = new Image(getClass().getResource("/com/example/graphictest/BossShoot/" + frame + ".png").toExternalForm());
        this.setFill(new ImagePattern(image));
    }

    public void setPhase2ShootImage(int frame) {
        if (frame == 21) frame--;
        Image image = new Image(getClass().getResource("/com/example/graphictest/bossShootPhase2/" + frame + ".png").toExternalForm());
        this.setFill(new ImagePattern(image));
    }

    public void setPhase3ShootImage(int frame) {
        if (frame == 33) frame--;
        Image image = new Image(getClass().getResource("/com/example/graphictest/bossShootPhase3/" + frame + ".png").toExternalForm());
        this.setFill(new ImagePattern(image));
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getHearts() {
        return hearts;
    }

    public void setHearts(double hearts) {
        this.hearts = hearts;
    }

    public boolean isDevil() {
        return isDevil;
    }

    public int getPhase() {
        return phase;
    }
}
