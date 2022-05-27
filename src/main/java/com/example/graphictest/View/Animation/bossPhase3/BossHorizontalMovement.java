package com.example.graphictest.View.Animation.bossPhase3;

import com.example.graphictest.Controller.GameController;
import javafx.animation.Transition;
import javafx.util.Duration;

public class BossHorizontalMovement extends Transition {

    public BossHorizontalMovement() {
        setCycleCount(-1);
        setCycleDuration(Duration.millis(3200));
    }

    @Override
    protected void interpolate(double v) {
        if (v <= 0.5)
            GameController.moveBossLeft();
        else
            GameController.moveBossRight();
    }
}
