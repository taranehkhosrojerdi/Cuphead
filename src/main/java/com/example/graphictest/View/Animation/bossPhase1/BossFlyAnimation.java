package com.example.graphictest.View.Animation.bossPhase1;

import javafx.animation.Transition;
import com.example.graphictest.Model.Components.*;
import javafx.util.Duration;

public class BossFlyAnimation extends Transition {

    private Boss boss;

    public BossFlyAnimation() {
        this.boss = Boss.getInstance();
        setCycleCount(2);
        setCycleDuration(Duration.millis(800));
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor((v * 6) + 1);
        boss.setFlyImage(frame);
    }
}
