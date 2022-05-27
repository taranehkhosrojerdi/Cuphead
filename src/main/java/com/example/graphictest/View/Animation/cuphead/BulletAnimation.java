package com.example.graphictest.View.Animation.cuphead;

import com.example.graphictest.App;
import com.example.graphictest.Controller.GameController;
import com.example.graphictest.Model.Components.Bullet;
import com.example.graphictest.Model.Components.CupHead;
import com.example.graphictest.Model.Components.MiniBoss;
import com.example.graphictest.View.GameMenu;
import javafx.animation.Transition;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class BulletAnimation extends Transition {

    private Bullet bullet;
    private AudioClip audioClip;

    public BulletAnimation() {
        this.bullet = new Bullet();
        setCycleDuration(Duration.millis(800));
        GameMenu.addComponentToPane(bullet);
        String path = (App.class.getResource("/com/example/graphictest/musics/gun.mp3")).toExternalForm();
        audioClip = new AudioClip(path);

        audioClip.play();
        setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {

        if (bullet != null) {
            bullet.setX(bullet.getX() + bullet.getSpeed());
            if (GameController.isOutOfScreen(bullet)) {
                GameMenu.removeComponentFromPane(bullet);
            }
            if (GameController.hasCollisionWithBoss(bullet)) {
                GameMenu.removeComponentFromPane(bullet);
               bullet = null;
                GameController.decreaseBossHearts(1);
                this.stop();
            }
            else if (GameController.getMiniBosses() != null) {
                for (int i = 0; i < GameController.getMiniBosses().size(); i++) {
                    MiniBoss miniBoss = GameController.getMiniBosses().get(i);
                    if (GameController.hasCollisionWithMiniBoss(bullet, miniBoss)) {
                        GameMenu.removeComponentFromPane(bullet);
                        bullet = null;
                        GameController.decreaseMiniBossHearts(miniBoss, 1);
                        this.stop();
                        break;
                    }
                }
            }
        }
    }
}
