package com.example.graphictest.View.Animation;

import com.example.graphictest.Controller.GameController;
import com.example.graphictest.Controller.UserController;
import com.example.graphictest.Model.Components.Boss;
import com.example.graphictest.Model.Components.CupHead;
import com.example.graphictest.View.GameMenu;
import javafx.animation.Transition;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ShowInfoAnimation extends Transition {

    private Text bossText;
    private Text cupHeadText;
    private Text playerScore;
    private double primaryCupHearts;

    public ShowInfoAnimation() {

        bossText = new Text("boss: " + Boss.getInstance().getHearts());
        bossText.setX(20);
        bossText.setY(20);
        GameMenu.addTextToPane(bossText);

        cupHeadText = new Text("cuphead: " + CupHead.getInstance().getHearts());
        cupHeadText.setX(20);
        cupHeadText.setY(40);
        GameMenu.addTextToPane(cupHeadText);
        primaryCupHearts = CupHead.getInstance().getHearts();

        playerScore = new Text("score: " + UserController.getLoggedInUser().getScore());
        playerScore.setX(20);
        playerScore.setY(60);
        GameMenu.addTextToPane(playerScore);

        setCycleCount(-1);
        setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        bossText.setText("boss: " + Boss.getInstance().getHearts() / 0.15 + "%");
        cupHeadText.setText("cuphead: " + (CupHead.getInstance().getHearts() * 100 / primaryCupHearts) + "%");
        playerScore.setText("score: " + UserController.getLoggedInUser().getScore());
    }
}
