package com.example.graphictest.View.Animation.bossPhase3;

import com.example.graphictest.Controller.GameController;
import com.example.graphictest.Model.Components.Boss;
import com.example.graphictest.Model.Components.Egg;
import com.example.graphictest.View.Animation.bossPhase2.BossFlyPhase2Animation;
import com.example.graphictest.View.Animation.bossPhase2.BossMovementAnimation;
import com.example.graphictest.View.GameMenu;
import javafx.animation.Transition;
import javafx.util.Duration;

public class BossFlyPhase3Animation extends Transition {

    private final Boss boss;
    private Egg egg;
    private boolean isNewCycle;
    private BossHorizontalMovement bossHorizontalMovement;

    private static BossFlyPhase3Animation instance;

    public static BossFlyPhase3Animation getInstance() {
        if (instance == null)
            instance = new BossFlyPhase3Animation();
        return instance;
    }

    private BossFlyPhase3Animation(){
        boss = Boss.getInstance();
        boss.switchToPhase3();
        bossHorizontalMovement = new BossHorizontalMovement();
        setCycleCount(-1);
        setCycleDuration(Duration.millis(3000));
        this.isNewCycle = true;
    }

    @Override
    protected void interpolate(double v) {
        int frame;
        if (v <= 0.5) {
            frame = (int) Math.floor((v * 32) + 1);
            boss.setPhase3FlyImage(frame);
        }
        else {
            frame = (int) Math.floor(((v - 0.5) * 64) + 1);
            boss.setPhase3ShootImage(frame);

            if (v >= 0.725) {
                if (egg == null && isNewCycle) {
                    egg = new Egg();
                    GameMenu.addComponentToPane(egg);
                }
                if (egg != null) {
                    egg.setY(egg.getY() - egg.getSpeed());
                    if (GameController.hasCollisionWithCupHead(egg)) {
                        GameMenu.removeComponentFromPane(egg);
                        egg = null;
                        isNewCycle = false;
                        GameController.decreaseCupHeadHearts();
                    }
                }
            }
            else {
                if (egg != null && GameController.isOutOfScreen(egg)) {
                    GameMenu.removeComponentFromPane(egg);
                    egg = null;
                }
                isNewCycle = true;
            }
        }
        bossHorizontalMovement.play();
    }
}
