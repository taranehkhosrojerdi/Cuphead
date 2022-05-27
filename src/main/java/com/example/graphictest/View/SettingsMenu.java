package com.example.graphictest.View;

import com.example.graphictest.App;
import com.example.graphictest.Controller.GameController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SettingsMenu {

    private static BorderPane pane;

    @FXML
    private Button mode1;
    @FXML
    private Button mode2;
    @FXML
    private Button mode3;
    @FXML
    private Button devilMode;

    private static int difficultyLevel;

    public void startGameMode1() {
        setDifficultyLevel(1);
        App.changeMenu("playGame-view");
    }

    public void startGameMode2() {
        setDifficultyLevel(2);
        App.changeMenu("playGame-view");
    }

    public void startGameMode3() {
        setDifficultyLevel(3);
        App.changeMenu("playGame-view");
    }

    public void startGameDevilMode() {
        setDifficultyLevel(4);
        App.changeMenu("playGame-view");
    }


    public static int getDifficultyLevel() {
        return difficultyLevel;
    }

    public static void setDifficultyLevel(int level) {
        LoginMenu.stopMenuAudio();
        difficultyLevel = level;
    }
}
