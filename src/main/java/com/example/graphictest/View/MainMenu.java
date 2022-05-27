package com.example.graphictest.View;

import com.example.graphictest.App;
import javafx.scene.control.Button;

public class MainMenu {

    public Button profileButton;
    public Button gameButton;
    public Button exitButton;
    public Button scoreBoardButton;

    public void enterProfileMenu() {
        App.changeMenu("profileMenu-view");
    }

    public void enterGame() {
        App.changeMenu("settings-view");
    }

    public void exitProgram() {
        App.changeMenu("loginMenu-view");
    }

    public void showScoreBoard() {
        App.changeMenu("scoreboard-view");
    }
}
