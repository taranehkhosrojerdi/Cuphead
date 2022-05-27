package com.example.graphictest.View.Animation.bossPhase2;

import com.example.graphictest.Controller.GameController;
import com.example.graphictest.Model.Components.Boss;
import com.example.graphictest.Model.Components.Egg;
import com.example.graphictest.View.GameMenu;
import javafx.animation.Transition;
import javafx.util.Duration;

public class BossFlyPhase2Animation extends Transition {

    private final Boss boss;
    private Egg egg;
    private boolean isNewCycle;
    private final BossMovementAnimation bossMovementAnimation;

    private static BossFlyPhase2Animation instance;

    public static BossFlyPhase2Animation getInstance() {
        if (instance == null)
            instance = new BossFlyPhase2Animation();
        return instance;
    }
    private BossFlyPhase2Animation(){
        boss = Boss.getInstance();
        boss.switchToPhase2();
        bossMovementAnimation = BossMovementAnimation.getInstance();
        setCycleCount(-1);
        setCycleDuration(Duration.millis(2000));
        this.isNewCycle = true;
    }

    @Override
    protected void interpolate(double v) {
        int frame;
        if (v <= 0.5) {
            frame = (int) Math.floor((v * 26) + 1);
            boss.setPhase2FlyImage(frame);
        }
        else {
            frame = (int) Math.floor(((v - 0.5) * 40) + 1);
            boss.setPhase2ShootImage(frame);

            if (v >= 0.575) {
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
            }
            else {
                if (egg != null && GameController.isOutOfScreen(egg)) {
                    GameMenu.removeComponentFromPane(egg);
                    egg = null;
                }
                isNewCycle = true;
            }
        }
        bossMovementAnimation.play();
    }

    public Egg getEgg() {
        return egg;
    }

    public void setEgg(Egg egg1) {
        egg = egg1;
    }
}
