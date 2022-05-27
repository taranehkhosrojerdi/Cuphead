package com.example.graphictest.View.Animation.bossPhase2;

import com.example.graphictest.Controller.GameController;
import javafx.animation.Transition;
import javafx.util.Duration;

import java.util.Random;

public class BossMovementAnimation extends Transition {

    private int direction;

    private static BossMovementAnimation instance;

    public static BossMovementAnimation getInstance() {
        if (instance == null)
            instance = new BossMovementAnimation();
        return instance;
    }

    private BossMovementAnimation() {
        setCycleCount(-1);
        setCycleDuration(Duration.millis(3200));
    }

    @Override
    protected void interpolate(double v) {

        if (v == 1) {
            Random random = new Random();
            direction = random.nextInt(4);
        }
        switch (direction) {
            case 0:
                GameController.moveBossDown();
                break;
            case 1:
                GameController.moveBossUp();
                break;
            case 2:
                GameController.moveBossRight();
                break;
            case 3:
                GameController.moveBossLeft();
                break;
        }
    }

}