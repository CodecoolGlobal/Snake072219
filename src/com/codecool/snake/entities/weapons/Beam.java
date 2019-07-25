package com.codecool.snake.entities.weapons;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.enemies.Enemy;
import com.codecool.snake.entities.snakes.Snake;
import javafx.geometry.Point2D;


public class Beam extends GameEntity implements Interactable, Animatable {

    private Point2D heading;
    GameEntity snakeHead;
    private Snake snake;

    public Beam(Snake snake,int speed) {
        this.snake =snake;
        setImage(Globals.getInstance().getImage("Beam"));

        snakeHead = snake.getHead();
        setX(snakeHead.getX());
        setY(snakeHead.getY());
        setRotate(snakeHead.getRotate() - 90);
        double direction = (snake.getHead().getRotate());
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);

    }

    @Override
    public void step() {

        if (isOutOfBounds()) {
            destroy();
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());

    }


    @Override
    public void apply(GameEntity entity) {
        if (entity instanceof Enemy) {
            System.out.print(getMessage());
            destroy();

        }

    }

    @Override
    public String getMessage() {
        return "Destroyed";
    }
}
