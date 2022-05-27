package com.example.graphictest.View;

import com.example.graphictest.App;
import com.example.graphictest.Controller.UserController;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ScoreboardMenu {

    public Button backButton;

    public VBox vBox;

    public void back() {
        App.changeMenu("mainMenu-view");
    }

    public void initialize() {
        UserController.initializeUsers();
        UserController.sortUsers();
        UserController.addUsersToScoreBoard(vBox);
    }


}
