package com.example.graphictest.View.Animation.cuphead;

import com.example.graphictest.Controller.GameController;
import com.example.graphictest.Model.Components.Bomb;
import com.example.graphictest.Model.Components.MiniBoss;
import com.example.graphictest.View.GameMenu;
import javafx.animation.Transition;
import javafx.util.Duration;

public class DropBombAnimation extends Transition {

    private Bomb bomb;

    public DropBombAnimation() {
        this.bomb = new Bomb();
        GameMenu.addComponentToPane(bomb);
        setCycleDuration(Duration.millis(800));
        setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        bomb.setY(bomb.getY() + bomb.getSpeed());
        if (bomb.getY() < 0) {
            GameMenu.removeComponentFromPane(bomb);
            this.stop();
        }
        if (GameController.hasCollisionWithBoss(bomb)) {
            GameController.decreaseBossHearts(2);
            GameMenu.removeComponentFromPane(bomb);
            bomb = null;
            this.stop();
        }
        else if (GameController.getMiniBosses() != null) {
            for (int i = 0; i < GameController.getMiniBosses().size(); i++) {
                MiniBoss miniBoss = GameController.getMiniBosses().get(i);
                if (GameController.hasCollisionWithMiniBoss(bomb, miniBoss)) {
                    GameMenu.removeComponentFromPane(bomb);
                    bomb = null;
                    GameController.decreaseMiniBossHearts(miniBoss, 2);
                    this.stop();
                    break;
                }
            }
        }
    }
}
