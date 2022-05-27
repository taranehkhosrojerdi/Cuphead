package com.example.graphictest.Model;

import javafx.scene.shape.Rectangle;

public class User {

    private String username;
    private String password;
    private Rectangle avatar;
    private double score;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rectangle getAvatar() {
        return avatar;
    }

    public void setAvatar(Rectangle avatar) {
        this.avatar = avatar;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
