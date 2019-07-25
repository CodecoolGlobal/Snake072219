package com.codecool.snake.entities.snakes;

import com.codecool.snake.Globals;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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
            result21.setX(70);
            result21.setY(20);
            Globals.getInstance().game.getChildren().add(result21);
            displayNumberOfLives1();
        } else if (getActualLives1() == 1) {
            Image result1 = new Image("1i.png");
            ImageView result21 = new ImageView(result1);
            result21.setX(70);
            result21.setY(20);
            Globals.getInstance().game.getChildren().add(result21);
            displayNumberOfLives1();
        } else if (getActualLives1() == 2) {
            Image result1 = new Image("2i.png");
            ImageView result21 = new ImageView(result1);
            result21.setX(70);
            result21.setY(20);
            Globals.getInstance().game.getChildren().add(result21);
            displayNumberOfLives1();
        } else if (getActualLives1() == 3) {
            Image result1 = new Image("3i.png");
            ImageView result21 = new ImageView(result1);
            result21.setX(70);
            result21.setY(20);
            Globals.getInstance().game.getChildren().add(result21);
            displayNumberOfLives1();
        } else {
            Image result1 = new Image("4i.png");
            ImageView result21 = new ImageView(result1);
            result21.setX(70);
            result21.setY(20);
            Globals.getInstance().game.getChildren().add(result21);
            displayNumberOfLives1();
        }
    }

    public void getNumberOfLives2() {
        if (getActualLives2() < 1) {
            Image result = new Image("0.png");
            ImageView result2 = new ImageView(result);
            result2.setX(770);
            result2.setY(20);
            Globals.getInstance().game.getChildren().add(result2);
            displayNumberOfLives2();
        } else if (getActualLives2() == 1) {
            Image result = new Image("1.png");
            ImageView result2 = new ImageView(result);
            result2.setX(770);
            result2.setY(20);
            Globals.getInstance().game.getChildren().add(result2);
            displayNumberOfLives2();
        } else if (getActualLives2() == 2) {
            Image result = new Image("2.png");
            ImageView result2 = new ImageView(result);
            result2.setX(770);
            result2.setY(20);
            Globals.getInstance().game.getChildren().add(result2);
            displayNumberOfLives2();
        } else if (getActualLives2() == 3) {
            Image result = new Image("3.png");
            ImageView result2 = new ImageView(result);
            result2.setX(770);
            result2.setY(20);
            Globals.getInstance().game.getChildren().add(result2);
            displayNumberOfLives2();
        } else {
            Image result = new Image("4.png");
            ImageView result2 = new ImageView(result);
            result2.setX(770);
            result2.setY(20);
            Globals.getInstance().game.getChildren().add(result2);
            displayNumberOfLives2();
        }
    }

    public void displayNumberOfLives1() {
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        Text t = new Text();
        t.setEffect(ds);
        t.setCache(true);
        t.setX(10);
        t.setY(70);
        t.setFill(Color.RED);
        t.setText(String.valueOf(getActualLives1()));
        t.setFont(Font.font(null, FontWeight.BOLD, 70));
        Globals.getInstance().game.getChildren().add(t);
    }

    public void displayNumberOfLives2() {
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        Text t2 = new Text();
        t2.setEffect(ds);
        t2.setCache(true);
        t2.setX(940);
        t2.setY(70);
        t2.setFill(Color.RED);
        t2.setText(String.valueOf(getActualLives2()));
        t2.setFont(Font.font(null, FontWeight.BOLD, 70));
        Globals.getInstance().game.getChildren().add(t2);
    }

}
