package com.example.graphictest.View;

import com.example.graphictest.App;
import com.example.graphictest.Controller.UserController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class LoginMenu {

    @FXML
    private TextField username;
    @FXML
    private TextField password;

    @FXML
    private Label loginText;
    @FXML
    private Label registerText;

    public Button registerButton;
    public Button loginButton;

    private static AudioClip audioClip;

    public void register() {
        if (audioClip == null || !audioClip.isPlaying())
            addMenuMusic();
        if (UserController.findUser(username.getText()) != null) {
            registerText.setText("username already exists");
            return;
        }
        UserController.registerUser(username.getText(), password.getText());
        App.changeMenu("mainMenu-view");
    }

    public void login() {
        if (audioClip == null || !audioClip.isPlaying())
            addMenuMusic();
        if (UserController.findUser(username.getText()) == null) {
            loginText.setText("username not found");
            return;
        }
        if (!UserController.isPasswordCorrect(UserController.findUser(username.getText()), password.getText())) {
            loginText.setText("password is not correct!");
            return;
        }

        UserController.loginUser(username.getText(), password.getText());
        App.changeMenu("mainMenu-view");
    }

    public static void addMenuMusic() {
        String path = (App.class.getResource("/com/example/graphictest/musics/menusTrack.mp3")).toExternalForm();
        audioClip = new AudioClip(path);
        audioClip.play();
    }

    public static void stopMenuAudio() {
        audioClip.stop();
    }
}