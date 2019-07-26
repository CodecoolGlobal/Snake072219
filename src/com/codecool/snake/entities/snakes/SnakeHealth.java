package com.codecool.snake.entities.snakes;

import com.codecool.snake.Globals;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public class SnakeHealth {

    public Map<String, Integer> getActualLives() {
        int SnakeLives1 = Globals.getInstance().snake.getLives();
        int SnakeLives2 = Globals.getInstance().snake2.getLives();
        Map<String, Integer> snakeHealth = new HashMap<>();
        snakeHealth.put("snake1", SnakeLives1);
        snakeHealth.put("snake2", SnakeLives2);
        return snakeHealth;
    }

    public void displayLives() {
        int snakeHP1 = getActualLives().get("snake1");
        int snakeHP2 = getActualLives().get("snake2");
        if (snakeHP1 < 1) {
            displayHealthBar("0i.png", 70, 20);
            displayNumberOfLives(snakeHP1, 10, 70);
        } else if (snakeHP1 == 1) {
            displayHealthBar("1i.png", 70, 20);
            displayNumberOfLives(snakeHP1, 10, 70);
        } else if (snakeHP1 == 2) {
            displayHealthBar("2i.png", 70, 20);
            displayNumberOfLives(snakeHP1, 10, 70);
        } else if (snakeHP1 == 3) {
            displayHealthBar("3i.png", 70, 20);
            displayNumberOfLives(snakeHP1, 10, 70);
        } else {
            displayHealthBar("4i.png", 70, 20);
            displayNumberOfLives(snakeHP1, 10, 70);
        }
        if (snakeHP2 < 1) {
            displayHealthBar("0.png", 770, 20);
            displayNumberOfLives(snakeHP2, 940, 70);
        } else if (snakeHP2 == 1) {
            displayHealthBar("1.png", 770, 20);
            displayNumberOfLives(snakeHP2, 940, 70);
        } else if (snakeHP2 == 2) {
            displayHealthBar("2.png", 770, 20);
            displayNumberOfLives(snakeHP2, 940, 70);
        } else if (snakeHP2 == 3) {
            displayHealthBar("3.png", 770, 20);
            displayNumberOfLives(snakeHP2, 940, 70);
        } else {
            displayHealthBar("4.png", 770, 20);
            displayNumberOfLives(snakeHP2, 940, 70);
        }
    }

    private void displayNumberOfLives(int snakeId, int X, int Y) {
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        Text t2 = new Text();
        t2.setEffect(ds);
        t2.setCache(true);
        t2.setX(X);
        t2.setY(Y);
        t2.setFill(Color.RED);
        t2.setText(String.valueOf(snakeId));
        t2.setFont(Font.font(null, FontWeight.BOLD, 70));
        Globals.getInstance().game.getChildren().add(t2);
    }

    private void displayHealthBar(String imageName, int X, int Y) {
        Image result1 = new Image(imageName);
        ImageView result21 = new ImageView(result1);
        result21.setX(X);
        result21.setY(Y);
        Globals.getInstance().game.getChildren().add(result21);

    }
}
