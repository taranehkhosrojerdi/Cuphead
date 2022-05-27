package com.example.graphictest.View.Animation.bossPhase1;

import com.example.graphictest.Controller.GameController;
import javafx.animation.Transition;
import javafx.scene.control.TableRow;
import javafx.util.Duration;

public class BossVerticalMovement extends Transition {

    private static BossVerticalMovement instance;

    public static BossVerticalMovement getInstance() {
        if (instance == null)
            instance = new BossVerticalMovement();
        return instance;
    }

    private BossVerticalMovement() {
        setCycleCount(-1);
        setCycleDuration(Duration.millis(3200));
    }

    @Override
    protected void interpolate(double v) {
        if (v <= 0.5)
            GameController.moveBossUp();
        else
            GameController.moveBossDown();
    }
}
