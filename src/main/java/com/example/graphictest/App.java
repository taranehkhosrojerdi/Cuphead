package com.example.graphictest;

import com.example.graphictest.View.GameMenu;
import com.example.graphictest.View.ProfileMenu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class App extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = loadFXML("loginMenu-view");
        Scene scene = new Scene(root, 720, 360);
        App.scene = scene;
        stage.setTitle("CupHead");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeMenu(String name){
        Parent root = loadFXML(name);
        App.scene.setRoot(root);
        if (name.equals("playGame-view"))
            GameMenu.initializeGame((BorderPane) root);
    }

    private static Parent loadFXML(String name){
        try {
            URL address = new URL(App.class.getResource("fxml/" + name + ".fxml").toString());
            return FXMLLoader.load(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}