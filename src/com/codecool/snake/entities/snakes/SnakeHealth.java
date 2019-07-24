package com.codecool.snake.entities.snakes;

import com.codecool.snake.Globals;
import javafx.scene.image.ImageView;

public class SnakeHealth extends ImageView {

    public int getActualHealth() {
        int SnakeHealth1 = Globals.getInstance().snake2.getHealth();
        return SnakeHealth1;
    }

    public void getNumberOfLives() {
        if (getActualHealth() < 1) {
            System.out.println("0");
        } else if (getActualHealth() >= 1 && getActualHealth() < 140) {

            System.out.println("1");
            setImage(Globals.getInstance().getImage("zerolife"));
            setX(100);
            setY(100);

        } else if (getActualHealth() >= 140 && getActualHealth() < 180) {

            System.out.println("2");

        } else if (getActualHealth() >= 160 && getActualHealth() < 220) {

            System.out.println("3");

        } else {

            System.out.println("4");

        }
    }

    public int getActualHealth2() {
        int SnakeHealth1 = Globals.getInstance().snake2.getHealth();
        return SnakeHealth1;
    }

    public void getNumberOfLives2() {
        if (getActualHealth() < 1) {
            System.out.println("20");
        } else if (getActualHealth() >= 1 && getActualHealth() < 140) {

            System.out.println("21");
            setImage(Globals.getInstance().getImage("zerolife"));
            setX(100);
            setY(100);

        } else if (getActualHealth() >= 140 && getActualHealth() < 180) {

            System.out.println("22");

        } else if (getActualHealth() >= 160 && getActualHealth() < 220) {

            System.out.println("23");

        } else {

            System.out.println("24");

        }
    }

}
