package com.example.graphictest.View.Animation.bossPhase1;

import com.example.graphictest.Model.Components.Boss;
import com.example.graphictest.Model.Components.Egg;
import com.example.graphictest.View.Animation.bossPhase2.BossMovementAnimation;
import javafx.animation.Transition;
import javafx.util.Duration;

public class BossMode1Animation extends Transition {
    private final BossFlyAnimation bossFlyAnimation;
    private final BossShootAnimation bossShootAnimation;
    private final BossVerticalMovement bossVerticalMovement;

    private static BossMode1Animation instance;

    public static BossMode1Animation getInstance() {
        if (instance == null)
            instance = new BossMode1Animation();
        return instance;
    }

    private BossMode1Animation() {
        this.bossFlyAnimation = new BossFlyAnimation();
        this.bossShootAnimation = new BossShootAnimation();
        this.bossVerticalMovement = BossVerticalMovement.getInstance();

        setCycleCount(-1);
        setCycleDuration(Duration.millis(3200));
    }

    @Override
    protected void interpolate(double v) {
        if (v <= 0.5)
            bossFlyAnimation.play();
        else {
            bossShootAnimation.play();
        }
        if (Boss.getInstance().isDevil())
            bossVerticalMovement.play();
    }

    public Egg getEgg() {
        return this.bossShootAnimation.getEgg();
    }

    public void setEgg(Egg egg) {
        bossShootAnimation.setEgg(egg);
    }
}
