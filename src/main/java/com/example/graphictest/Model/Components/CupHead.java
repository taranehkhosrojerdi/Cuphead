package com.example.graphictest.Model.Components;

import com.example.graphictest.View.SettingsMenu;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class CupHead extends Rectangle {

    private int speed;
    private double primaryX;
    private double primaryY;
    private double hearts;
    private double vulnerability;
    private double power;
    private boolean weaponIsBullet;

    private static CupHead instance;

    public static CupHead getInstance() {
        if (instance == null)
            instance = new CupHead();
        return instance;
    }

    private CupHead() {
        speed = 10;
        this.setX(80);
        this.setY(155);
        primaryX = 80;
        primaryY = 155;
        this.setWidth(54.5);
        this.setHeight(45.5);
        Image cupHeadImage = new Image(getClass().getResource("/com/example/graphictest/images/blue.png").toExternalForm());
        this.setFill(new ImagePattern(cupHeadImage));
        this.weaponIsBullet = true;

        switch (SettingsMenu.getDifficultyLevel()) {
            case 1:
                this.hearts = 10;
                this.vulnerability = 0.5;
                this.power = 1.5;
                break;
            case 2:
                this.hearts = 5;
                this.vulnerability = 1;
                this.power = 1;
                break;
            default:
                this.hearts = 2;
                this.vulnerability = 1.5;
                this.power = 0.5;
                break;
        }
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

    public double getVulnerability() {
        return vulnerability;
    }

    public void setVulnerability(double vulnerability) {
        this.vulnerability = vulnerability;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void changeDefaultWeapon() {
        this.weaponIsBullet = !weaponIsBullet;
    }

    public boolean getWeaponIsBullet() {
        return weaponIsBullet;
    }

    public double getPrimaryY() {
        return primaryY;
    }

    public void setPrimaryY(double primaryY) {
        this.primaryY = primaryY;
    }

    public double getPrimaryX() {
        return primaryX;
    }

    public void setPrimaryX(double primaryX) {
        this.primaryX = primaryX;
    }
}
