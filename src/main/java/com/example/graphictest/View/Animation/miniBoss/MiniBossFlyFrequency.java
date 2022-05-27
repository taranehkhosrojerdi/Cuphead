package com.example.graphictest.View.Animation.miniBoss;

import javafx.animation.Transition;
import javafx.util.Duration;

public class MiniBossFlyFrequency extends Transition {

    private MiniBossFlyAnimation miniBossFlyAnimation;

    public MiniBossFlyFrequency() {
        this.miniBossFlyAnimation = new MiniBossFlyAnimation();
        setCycleCount(-1);
        setCycleDuration(Duration.millis((int)(50000 / miniBossFlyAnimation.getAMiniBoss().getSpeed())));
    }

    @Override
    protected void interpolate(double v) {
        if (v <= 0.25) {
            if (miniBossFlyAnimation == null)
                miniBossFlyAnimation = new MiniBossFlyAnimation();
            miniBossFlyAnimation.play();
        } else {
            miniBossFlyAnimation = null;
        }
    }
}
