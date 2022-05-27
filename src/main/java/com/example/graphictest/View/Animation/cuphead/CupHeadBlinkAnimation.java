package com.example.graphictest.View.Animation.cuphead;

import com.example.graphictest.Controller.GameController;
import com.example.graphictest.Model.Components.CupHead;
import com.example.graphictest.View.GameMenu;
import javafx.animation.Transition;
import javafx.util.Duration;

public class CupHeadBlinkAnimation extends Transition {

    private final CupHead cupHead;

    public CupHeadBlinkAnimation() {
        cupHead = GameMenu.getCupHead();
        setCycleCount(1);
        setCycleDuration(Duration.millis(1010));
        GameMenu.removeComponentFromPane(cupHead);
    }
    @Override
    protected void interpolate(double v) {
        if (v > 0.999) {
            GameMenu.addComponentToPane(cupHead);
            GameController.addCupHeadToPane();
            this.stop();
        }
    }
}
