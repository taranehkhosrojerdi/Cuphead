package com.example.graphictest.View.Animation.bossPhase1;

import com.example.graphictest.Controller.GameController;
import com.example.graphictest.Model.Components.Boss;
import com.example.graphictest.Model.Components.Egg;
import com.example.graphictest.View.GameMenu;
import javafx.animation.Transition;
import javafx.util.Duration;

public class BossShootAnimation extends Transition {

    private final Boss boss;
    private Egg egg;
    private boolean isNewCycle;

    public BossShootAnimation() {
        this.boss = Boss.getInstance();
        this.setCycleDuration(Duration.millis(1600));
        this.setCycleCount(1);
        this.isNewCycle = true;
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor((v * 12) + 1);
        boss.setShootImage(frame);


        if (v >= 0.15) {
            if (egg == null && isNewCycle) {
                egg = new Egg();
                GameMenu.addComponentToPane(egg);
            }
            if (egg != null) {
                egg.setX(egg.getX() - egg.getSpeed());
                if (GameController.hasCollisionWithCupHead(egg)) {
                    GameMenu.removeComponentFromPane(egg);
                    egg = null;
                    isNewCycle = false;
                    GameController.decreaseCupHeadHearts();
                }
            }
        } else {
            if (egg != null && GameController.isOutOfScreen(egg)) {
                GameMenu.removeComponentFromPane(egg);
                egg = null;
            }
            isNewCycle = true;
        }

    }

    public Egg getEgg() {
        return egg;
    }

    public void setEgg(Egg egg1) {
        egg = egg1;
    }
}
