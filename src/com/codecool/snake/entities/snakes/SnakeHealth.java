package com.codecool.snake.entities.snakes;

import com.codecool.snake.Globals;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SnakeHealth {

    public int getActualHealth() {
        int SnakeHealth1 = Globals.getInstance().snake.getHealth();
        return SnakeHealth1;
    }

    public int getActualHealth2() {
        int SnakeHealth2 = Globals.getInstance().snake2.getHealth();
        return SnakeHealth2;
    }

    public void getNumberOfLives() {
        if (getActualHealth() < 1) {
            Image result1 = new Image("0.png");
            ImageView result21 = new ImageView(result1);
            result21.setX(20);
            result21.setY(20);
            Globals.getInstance().game.getChildren().add(result21);
        } else if (getActualHealth() >= 1 && getActualHealth() < 140) {
            Image result1 = new Image("1i.png");
            ImageView result21 = new ImageView(result1);
            result21.setX(20);
            result21.setY(20);
            Globals.getInstance().game.getChildren().add(result21);
        } else if (getActualHealth() >= 140 && getActualHealth() < 180) {
            Image result1 = new Image("2i.png");
            ImageView result21 = new ImageView(result1);
            result21.setX(20);
            result21.setY(20);
            Globals.getInstance().game.getChildren().add(result21);
        } else if (getActualHealth() >= 180 && getActualHealth() < 220) {
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
        if (getActualHealth2() < 1) {Image result = new Image("0.png");
            ImageView result2 = new ImageView(result);
            result2.setX(800);
            result2.setY(20);
            Globals.getInstance().game.getChildren().add(result2);
        } else if (getActualHealth2() >= 1 && getActualHealth2() < 140) {
            Image result = new Image("1.png");
            ImageView result2 = new ImageView(result);
            result2.setX(800);
            result2.setY(20);
            Globals.getInstance().game.getChildren().add(result2);
        } else if (getActualHealth2() >= 140 && getActualHealth2() < 180) {
            Image result = new Image("2.png");
            ImageView result2 = new ImageView(result);
            result2.setX(800);
            result2.setY(20);
            Globals.getInstance().game.getChildren().add(result2);
        } else if (getActualHealth2() >= 180 && getActualHealth2() < 220) {
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
