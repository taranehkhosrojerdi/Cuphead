package com.example.graphictest.View.Animation.cuphead;

import com.example.graphictest.Controller.GameController;
import com.example.graphictest.Model.Components.CupHead;
import com.example.graphictest.Model.Components.MiniBoss;
import com.example.graphictest.Model.Components.Rocket;
import com.example.graphictest.View.GameMenu;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class RocketAnimation extends Transition {

    private Rocket rocket;
    private Rectangle boomImage;

    public RocketAnimation() {
        this.rocket = new Rocket();
        GameMenu.addComponentToPane(rocket);
        setCycleCount(-1);
        setCycleDuration(Duration.millis(800));

        boomImage = new Rectangle();
        boomImage.setWidth(82.5);
        boomImage.setHeight(73.5);
        Image image = new Image(getClass().getResource("/com/example/graphictest/images/boom.png").toExternalForm());
        boomImage.setFill(new ImagePattern(image));
    }

    @Override
    protected void interpolate(double v) {
        rocket.setX(rocket.getX() + rocket.getSpeed());
        if (GameController.hasCollisionWithBoss(rocket)) {
            GameController.decreaseBossHearts(4);
            GameMenu.removeComponentFromPane(rocket);
            GameMenu.addComponentToPane(CupHead.getInstance());
            GameController.resetCupHeadLocation();
            new CupHeadBlinkAnimation().play();
            this.stop();
        }
        else if (GameController.getMiniBosses() != null) {
            for (int i = 0; i < GameController.getMiniBosses().size(); i++) {
                MiniBoss miniBoss = GameController.getMiniBosses().get(i);
                if (GameController.hasCollisionWithMiniBoss(rocket, miniBoss)) {
                    GameMenu.removeComponentFromPane(rocket);
                    GameMenu.addComponentToPane(CupHead.getInstance());
//                    rocket = null;
                    GameController.decreaseMiniBossHearts(miniBoss, 10);
                    GameController.resetCupHeadLocation();
                    new CupHeadBlinkAnimation().play();
                    this.stop();
                    break;
                }
            }
        }
    }
}
