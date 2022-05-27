package com.example.graphictest.View.Animation.miniBoss;

import com.example.graphictest.Controller.GameController;
import com.example.graphictest.Model.Components.MiniBoss;
import com.example.graphictest.View.GameMenu;
import javafx.animation.Transition;
import javafx.util.Duration;

import java.util.ArrayList;

public class MiniBossFlyAnimation extends Transition {

    private ArrayList<MiniBoss> miniBosses;
    private boolean reachedFive;
    private MiniBossFlyAnimation instance;

    public MiniBossFlyAnimation getInstance() {
        if (instance == null)
            instance = new MiniBossFlyAnimation();
        return instance;
    }
    public MiniBossFlyAnimation() {
        this.miniBosses = new ArrayList<>();
        GameController.setMiniBosses(new ArrayList<>());
        MiniBoss miniBoss = new MiniBoss();
        miniBosses.add(miniBoss);
        GameController.getMiniBosses().add(miniBoss);
        GameMenu.addComponentToPane(miniBosses.get(0));
        reachedFive = false;
        setCycleCount(-1);
        setCycleDuration(Duration.millis((int)(1250 / miniBosses.get(0).getSpeed())));
    }

    @Override
    protected void interpolate(double v) {
            int frame = (int)Math.floor((v * 4) + 1);
            for (int i = 0; i < miniBosses.size(); i++) {
                MiniBoss miniBoss = miniBosses.get(i);
                miniBoss.setX(miniBoss.getX() - miniBoss.getSpeed());
                miniBoss.setFlyImage(frame);
                if (GameController.isOutOfScreen(miniBoss)) {
                    GameMenu.removeComponentFromPane(miniBoss);
                }
                if (GameController.hasCollisionWithCupHead(miniBoss)) {
                    GameController.decreaseCupHeadHearts();
                    GameMenu.removeComponentFromPane(miniBoss);
                    miniBosses.remove(miniBoss);
                    GameController.getMiniBosses().remove(miniBoss);
                }
                if (GameController.checkForMiniBossDeath(miniBoss)) {
                    GameMenu.removeComponentFromPane(miniBoss);
                    miniBosses.remove(miniBoss);
                    GameController.getMiniBosses().remove(miniBoss);
                    GameController.addScore(5);
                }
            }
            if (miniBosses.size() >= 4) {
                reachedFive = true;
            }
            if (!reachedFive && miniBosses.get(miniBosses.size() - 1).getX() < 640) {
                MiniBoss miniBoss = new MiniBoss();
                miniBosses.add(miniBoss);
                GameController.getMiniBosses().add(miniBoss);
                GameMenu.addComponentToPane(miniBosses.get(miniBosses.size() - 1));
            }

    }

    public MiniBoss getAMiniBoss() {
        return this.miniBosses.get(0);
    }
}
