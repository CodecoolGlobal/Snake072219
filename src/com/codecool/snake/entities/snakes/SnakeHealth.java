package com.codecool.snake.entities.snakes;

import com.codecool.snake.Globals;
import javafx.scene.image.Image;

public class SnakeHealth {

    public int getActualHealth() {
        int SnakeHealth1 = Globals.getInstance().snake2.getHealth();
        return SnakeHealth1;
    }

    public void getNumberOfLives() {
        if (getActualHealth() < 1) {
        } else if (getActualHealth() >= 1 && getActualHealth() < 140) {

            setImage(Globals.getInstance().getImage("zerolife"));

        } else if (getActualHealth() >= 140 && getActualHealth() < 180) {
        } else if (getActualHealth() >= 160 && getActualHealth() < 220) {
        } else {
        }
    }

    private void setImage(Image zerolife) {
    }
}
