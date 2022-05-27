package com.example.graphictest.View;

import com.example.graphictest.App;
import com.example.graphictest.Controller.GameController;
import com.example.graphictest.Model.Components.*;
import com.example.graphictest.View.Animation.ShowInfoAnimation;
import com.example.graphictest.View.Animation.bossPhase1.BossMode1Animation;
import com.example.graphictest.View.Animation.bossPhase2.BossFlyPhase2Animation;
import com.example.graphictest.View.Animation.bossPhase3.BossFlyPhase3Animation;
import com.example.graphictest.View.Animation.miniBoss.MiniBossFlyFrequency;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;

import java.nio.file.Paths;

public class GameMenu {

    private static final CupHead cupHead = CupHead.getInstance();
    private static final Boss boss = Boss.getInstance();
    private static BorderPane pane;

    public static CupHead getCupHead() {
        return cupHead;
    }

    public static Boss getBoss() {
        return boss;
    }

    public static void initializeGame(BorderPane borderPane) {

        pane = borderPane;
        addBackground();
        pane.getChildren().add(cupHead);
        pane.getChildren().add(boss);
        GameController.addCupHeadToPane();

        BossMode1Animation.getInstance().play();
        new MiniBossFlyFrequency().play();
        new ShowInfoAnimation().play();
        addGameMusic();
    }

    private static void addBackground() {
        Rectangle background = new Rectangle();
        background.setX(0);
        background.setY(0);
        background.setWidth(720);
        background.setHeight(360);
        Image image = new Image(App.class.getResource("/com/example/graphictest/images/gameBackground.png").toExternalForm());
        background.setFill(new ImagePattern(image));
        pane.getChildren().add(background);
    }

    public static void addComponentToPane(Rectangle rect) {
        pane.getChildren().remove(rect);
        pane.getChildren().add(rect);
    }

    public static void addTextToPane(Text text) {
        pane.getChildren().add(text);
    }

    public static void removeComponentFromPane(Rectangle rect) {
        pane.getChildren().remove(rect);
    }

    public static void addGameMusic() {
        String path = (App.class.getResource("/com/example/graphictest/musics/gameTrack.mp3")).toExternalForm();
        AudioClip audioClip = new AudioClip(path);
        audioClip.play();
    }

    public static void addEndBox(boolean win) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        Text text = new Text();
        if (win) {
            text.setText("You won!");
        } else {
            text.setText("You lost!");
        }
        text.setX(310);
        text.setY(100);
        text.setStyle("-fx-font: 24 arial;");
        vBox.getChildren().add(text);
        pane.getChildren().add(text);
    }
}
