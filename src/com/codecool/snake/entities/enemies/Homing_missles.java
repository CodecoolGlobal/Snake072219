package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.Snake;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.entities.weapons.Beam;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Homing_missles extends Enemy implements Animatable, Interactable {

    private Point2D heading;
    private static Random rnd = new Random();

    public Homing_missles(){
        super(-20,-10);

        setImage(Globals.getInstance().getImage("Enemy2"));
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);

        double direction = rnd.nextDouble() * 1;
        setRotate(direction);

        int speed = 1;
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
        if(entity instanceof SnakeHead){
            System.out.println(getMessage());
            destroy();
        }
        if(entity instanceof Beam){
            destroy();
        }
        List<Snake> snakes = new ArrayList<>();
        snakes.add(Globals.getInstance().snake);
        snakes.add(Globals.getInstance().snake2);
        int index = rnd.nextInt(snakes.size());
        snakes.get(index).getHead();

        double dir = Utils.getDirectionBetweenTwo(this, snakes.get(index).getHead());
        setRotate(dir);
        int speed = 1;
        heading = Utils.directionToVector(dir,speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }
    @Override
    public String getMessage() {
        return (getDamage() + " damage");
    }
}

