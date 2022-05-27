package com.example.graphictest.View;

import com.example.graphictest.App;
import com.example.graphictest.Controller.UserController;
import com.example.graphictest.Model.User;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ProfileMenu {

    @FXML
    private TextField username;

    @FXML
    private Label changeUsernameText;

    @FXML
    private TextField password;

    @FXML
    private Label changePasswordText;

    public Button deleteAccountButton;
    public Button logoutButton;
    public Button changeUsernameButton;
    public Button changePasswordButton;
    public VBox vBox;

    public void changeUsername() {
        if (UserController.findUser(username.getText()) != null) {
            changeUsernameText.setText("this username has already been taken");
            return;
        }

        UserController.changeUsername(username.getText());
        changeUsernameText.setText("username changed successfully");
    }

    public void changePassword() {
        UserController.changePassword(password.getText());
        changePasswordText.setText("password changed successfully");
    }

    public void logout() {
        UserController.logout();
        App.changeMenu("loginMenu-view");
    }

    public void deleteAccount() {
        UserController.deleteAccount();
        App.changeMenu("loginMenu-view");
    }

    public void initialize() {

        UserController.addRandomAvatar(vBox);
    //    UserController.addAvatars(pane);
    }


}
