package com.codecool.snake.entities.snakes;

import com.codecool.snake.Globals;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SnakeHealth {

    public int getActualLives1() {
        int SnakeLives1 = Globals.getInstance().snake.getLives();
        return SnakeLives1;
    }

    public int getActualLives2() {
        int SnakeLives2 = Globals.getInstance().snake2.getLives();
        return SnakeLives2;
    }

    public void getNumberOfLives() {
        if (getActualLives1() < 1) {
            Image result1 = new Image("0.png");
            ImageView result21 = new ImageView(result1);
            result21.setX(20);
            result21.setY(20);
            Globals.getInstance().game.getChildren().add(result21);
        } else if (getActualLives1() == 1) {
            Image result1 = new Image("1i.png");
            ImageView result21 = new ImageView(result1);
            result21.setX(20);
            result21.setY(20);
            Globals.getInstance().game.getChildren().add(result21);
        } else if (getActualLives1() == 2) {
            Image result1 = new Image("2i.png");
            ImageView result21 = new ImageView(result1);
            result21.setX(20);
            result21.setY(20);
            Globals.getInstance().game.getChildren().add(result21);
        } else if (getActualLives1() == 3) {
            Image result1 = new Image("3i.png");
            ImageView result21 = new ImageView(result1);
            result21.setX(20);
            result21.setY(20);
            Globals.getInstance().game.getChildren().add(result21);
        } else {
            Image result1 = new Image("4i.png");
            ImageView result21 = new ImageView(result1);
            result21.setX(20);
            result21.setY(20);
            Globals.getInstance().game.getChildren().add(result21);

        }
    }

    public void getNumberOfLives2() {
        if (getActualLives2() < 1) {
            Image result = new Image("0.png");
            ImageView result2 = new ImageView(result);
            result2.setX(800);
            result2.setY(20);
            Globals.getInstance().game.getChildren().add(result2);
        } else if (getActualLives2() == 1) {
            Image result = new Image("1.png");
            ImageView result2 = new ImageView(result);
            result2.setX(800);
            result2.setY(20);
            Globals.getInstance().game.getChildren().add(result2);
        } else if (getActualLives2() == 2) {
            Image result = new Image("2.png");
            ImageView result2 = new ImageView(result);
            result2.setX(800);
            result2.setY(20);
            Globals.getInstance().game.getChildren().add(result2);
        } else if (getActualLives2() == 3) {
            Image result = new Image("3.png");
            ImageView result2 = new ImageView(result);
            result2.setX(800);
            result2.setY(20);
            Globals.getInstance().game.getChildren().add(result2);
        } else {
            Image result = new Image("4.png");
            ImageView result2 = new ImageView(result);
            result2.setX(800);
            result2.setY(20);
            Globals.getInstance().game.getChildren().add(result2);

        }
    }

}
