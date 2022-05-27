package com.example.graphictest.Controller;

import com.example.graphictest.App;
import com.example.graphictest.Model.User;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class UserController {

    private static ArrayList<User> users = new ArrayList<>();
    private static User loggedInUser;

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        UserController.loggedInUser = loggedInUser;
    }

    public static boolean isPasswordCorrect(User user, String password) {
        return user.getPassword().equals(password);
    }

    public static User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    public static void registerUser(String username, String password) {
        User user = new User(username, password);
        users.add(user);
        setLoggedInUser(user);
    }

    public static void loginUser(String username, String password) {
        User user = findUser(username);
        setLoggedInUser(user);
    }

    public static void changeUsername(String newUsername) {
        loggedInUser.setUsername(newUsername);
    }

    public static void changePassword(String password) {
        loggedInUser.setPassword(password);
    }

    public static void logout() {
        loggedInUser = null;
    }

    public static void deleteAccount() {
        users.remove(loggedInUser);
        loggedInUser = null;
    }

    public static void addRandomAvatar(VBox vBox) {
        if (loggedInUser.getAvatar() == null) {
            loggedInUser.setAvatar(new Rectangle());
            loggedInUser.getAvatar().setX(20);
            loggedInUser.getAvatar().setY(30);
            loggedInUser.getAvatar().setWidth(100);
            loggedInUser.getAvatar().setHeight(100);
            Random random = new Random();
            int number = random.nextInt(4) + 1;
            Image image = new Image(App.class.getResource("/com/example/graphictest/avatars/" + number +".jpg").toExternalForm());
            loggedInUser.getAvatar().setFill(new ImagePattern(image));
            vBox.getChildren().add(loggedInUser.getAvatar());
        }
    }

    public static void changeAvatar(BorderPane pane, int number) {
        Image image = new Image(App.class.getResource("/com/example/graphictest/avatars/" + number +".jpg").toExternalForm());
        loggedInUser.getAvatar().setFill(new ImagePattern(image));
        pane.getChildren().add(loggedInUser.getAvatar());
    }

    public static void addAvatars(BorderPane pane) {
        Rectangle avatar1 = new Rectangle();
        avatar1.setX(20);
        avatar1.setY(200);
        avatar1.setWidth(40);
        avatar1.setHeight(40);
        Image image1 = new Image(App.class.getResource("/com/example/graphictest/avatars/1.jpg").toExternalForm());
        avatar1.setFill(new ImagePattern(image1));
        pane.getChildren().add(avatar1);

        Rectangle avatar2 = new Rectangle();
        avatar2.setX(70);
        avatar2.setY(200);
        avatar2.setWidth(40);
        avatar2.setHeight(40);
        Image image2 = new Image(App.class.getResource("/com/example/graphictest/avatars/2.jpg").toExternalForm());
        avatar2.setFill(new ImagePattern(image2));
        pane.getChildren().add(avatar2);

        Rectangle avatar3 = new Rectangle();
        avatar3.setX(120);
        avatar3.setY(200);
        avatar3.setWidth(40);
        avatar3.setHeight(40);
        Image image3 = new Image(App.class.getResource("/com/example/graphictest/avatars/3.jpg").toExternalForm());
        avatar3.setFill(new ImagePattern(image3));
        pane.getChildren().add(avatar3);

        Rectangle avatar4 = new Rectangle();
        avatar4.setX(170);
        avatar4.setY(200);
        avatar4.setWidth(40);
        avatar4.setHeight(40);
        Image image4 = new Image(App.class.getResource("/com/example/graphictest/avatars/4.jpg").toExternalForm());
        avatar4.setFill(new ImagePattern(image4));
        pane.getChildren().add(avatar4);
    }

    public static void initializeUsers() {
        User user1 = new User("player1", "player1");
        user1.setScore(12);
        users.add(user1);

        User user2 = new User("player2", "player2");
        user2.setScore(14);
        users.add(user2);

        User user3 = new User("player3", "player3");
        user3.setScore(8);
        users.add(user3);

        User user4 = new User("player4", "player4");
        user4.setScore(19);
        users.add(user4);

        User user5 = new User("player5", "player5");
        user5.setScore(3);
        users.add(user5);

        User user6 = new User("player6", "player6");
        user6.setScore(10);
        users.add(user6);

        User user7 = new User("player7", "player7");
        user7.setScore(0);
        users.add(user7);

        User user8 = new User("player8", "player8");
        user8.setScore(5);
        users.add(user8);

        User user9 = new User("player9", "player9");
        user9.setScore(13);
        users.add(user9);

        User user10 = new User("player10", "player10");
        user10.setScore(-1);
        users.add(user10);
    }

    public static void sortUsers() {
        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                if (users.get(i).getScore() < users.get(j).getScore())
                    Collections.swap(users, i, j);
            }
        }
    }

    public static void addUsersToScoreBoard(VBox vBox) {
         for (int i = 0; i < 10; i++) {
             Text text = new Text();
            text.setText(users.get(i).getUsername() + "  :  " + users.get(i).getScore());
            vBox.getChildren().add(text);
        }
    }

}
