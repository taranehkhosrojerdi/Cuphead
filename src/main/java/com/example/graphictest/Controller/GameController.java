package com.example.graphictest.Controller;

import com.example.graphictest.Model.Components.*;
import com.example.graphictest.View.Animation.bossPhase1.BossMode1Animation;
import com.example.graphictest.View.Animation.bossPhase1.BossVerticalMovement;
import com.example.graphictest.View.Animation.bossPhase2.BossFlyPhase2Animation;
import com.example.graphictest.View.Animation.bossPhase2.BossMovementAnimation;
import com.example.graphictest.View.Animation.bossPhase3.BossFlyPhase3Animation;
import com.example.graphictest.View.Animation.cuphead.BulletAnimation;
import com.example.graphictest.View.Animation.cuphead.CupHeadBlinkAnimation;
import com.example.graphictest.View.Animation.cuphead.DropBombAnimation;
import com.example.graphictest.View.Animation.cuphead.RocketAnimation;
import com.example.graphictest.View.GameMenu;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class GameController {

    private static final CupHead cupHead = GameMenu.getCupHead();
    private static final Boss boss = GameMenu.getBoss();
    private static ArrayList<MiniBoss> miniBosses;

    public static void moveCupHeadRight() {
        if (cupHead.getX() + cupHead.getSpeed() <= 720 - cupHead.getWidth())
            cupHead.setX(cupHead.getX() + cupHead.getSpeed());
        if (hasCollisionWithBoss(cupHead)) {
            decreaseCupHeadHearts();
        }
    }

    public static void moveCupHeadLeft() {
        if (cupHead.getX() - cupHead.getSpeed() >= 0)
            cupHead.setX(cupHead.getX() - cupHead.getSpeed());
        if (hasCollisionWithBoss(cupHead)) {
            decreaseCupHeadHearts();
        }
    }

    public static void moveCupHeadUp() {
        if (cupHead.getY() - cupHead.getSpeed() >= 0)
            cupHead.setY(cupHead.getY() - cupHead.getSpeed());
        if (hasCollisionWithBoss(cupHead)) {
            decreaseCupHeadHearts();
        }
    }

    public static void moveCupHeadDown() {
        if (cupHead.getY() + cupHead.getSpeed() <= 360 - cupHead.getHeight())
            cupHead.setY(cupHead.getY() + cupHead.getSpeed());
        if (hasCollisionWithBoss(cupHead)) {
            decreaseCupHeadHearts();
        }
    }

    public static void moveBossLeft() {
        if (boss.getX() > 300)
            boss.setX(boss.getX() - boss.getSpeed());
    }

    public static void moveBossRight() {
        if (boss.getX() + boss.getWidth() < 700)
            boss.setX(boss.getX() + boss.getSpeed());
    }

    public static void moveBossDown() {
        if (boss.getY() + boss.getHeight() < 300)
            boss.setY(boss.getY() + boss.getSpeed());
    }

    public static void moveBossUp() {
        if (boss.getY() > 60)
            boss.setY(boss.getY() - boss.getSpeed());
    }

    public static boolean isOutOfScreen(Rectangle rectangle) {
        return rectangle.getX() + rectangle.getWidth() < 0
                || rectangle.getX() > 720
                || rectangle.getY() + rectangle.getHeight() < 0
                || rectangle.getY() > 360;
    }


    public static boolean hasCollisionWithCupHead(Rectangle rect) {
        return cupHead.getBoundsInParent().intersects(rect.getBoundsInParent());
    }

    public static boolean hasCollisionWithBoss(Rectangle rectangle) {
        return boss.getBoundsInParent().intersects(rectangle.getBoundsInParent());
    }

    public static boolean hasCollisionWithMiniBoss(Rectangle rectangle, MiniBoss miniBoss) {
        return miniBoss.getBoundsInParent().intersects(rectangle.getBoundsInParent());
    }

    public static void decreaseCupHeadHearts() {
        resetCupHeadLocation();
        cupHead.setHearts(cupHead.getHearts() - cupHead.getVulnerability());
        new CupHeadBlinkAnimation().play();
        if (checkForLose()) {
            GameMenu.addEndBox(false);
        }
    }

    public static void decreaseBossHearts(int times) {
        boss.setHearts(boss.getHearts() - (cupHead.getPower() * times));
        if (boss.isDevil() && boss.getHearts() <= 3)
            switchToMode3();
        else if (boss.isDevil() && boss.getHearts() <= 7.5)
            switchToMode2();
        if (checkForWin()) {
            addScore(cupHead.getHearts() * 10);
            GameMenu.addEndBox(true);
        }
    }

    public static void decreaseMiniBossHearts(MiniBoss miniBoss, int times) {
        miniBoss.setHearts(miniBoss.getHearts() - (cupHead.getPower() * times));
    }

    public static boolean checkForLose() {
        return cupHead.getHearts() <= 0;
    }

    public static boolean checkForWin() {
        return boss.getHearts() <= 0;
    }

    public static void addCupHeadToPane() {
        cupHead.requestFocus();
        cupHead.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String keyName = keyEvent.getCode().getName();
                switch (keyName) {
                    case "Left":
                        GameController.moveCupHeadLeft();
                        break;
                    case "Right":
                        GameController.moveCupHeadRight();
                        break;
                    case "Up":
                        GameController.moveCupHeadUp();
                        break;
                    case "Down":
                        GameController.moveCupHeadDown();
                        break;
                    case "Space":
                        if (cupHead.getWeaponIsBullet())
                            new BulletAnimation().play();
                        else
                            new DropBombAnimation().play();
                        break;
                    case "Tab":
                        cupHead.changeDefaultWeapon();
                        break;
                    case "Enter":
                        GameMenu.removeComponentFromPane(cupHead);
                        new RocketAnimation().play();
                        break;
                }
            }
        });
    }

    public static void resetCupHeadLocation() {
        cupHead.setX(cupHead.getPrimaryX());
        cupHead.setY(cupHead.getPrimaryY());
    }

    public static ArrayList<MiniBoss> getMiniBosses() {
        return miniBosses;
    }

    public static void setMiniBosses(ArrayList<MiniBoss> miniBosses) {
        GameController.miniBosses = miniBosses;
    }

    public static boolean checkForMiniBossDeath(MiniBoss miniBoss) {
        return miniBoss.getHearts() <= 0;
    }

    public static void addScore(double amount) {
        UserController.getLoggedInUser().setScore(UserController.getLoggedInUser().getScore() + amount);
    }

    public static void switchToMode2() {
        if (BossMode1Animation.getInstance().getEgg() != null) {
            GameMenu.removeComponentFromPane(BossMode1Animation.getInstance().getEgg());
            BossMode1Animation.getInstance().setEgg(null);
        }
        BossMode1Animation.getInstance().stop();
        BossVerticalMovement.getInstance().stop();
        BossFlyPhase2Animation.getInstance().play();
    }

    public static void switchToMode3() {
        if (BossFlyPhase2Animation.getInstance().getEgg() != null) {
            GameMenu.removeComponentFromPane(BossFlyPhase2Animation.getInstance().getEgg());
            BossFlyPhase2Animation.getInstance().setEgg(null);
        }
        BossFlyPhase2Animation.getInstance().stop();
        BossMovementAnimation.getInstance().stop();
        BossFlyPhase3Animation.getInstance().play();
    }

}