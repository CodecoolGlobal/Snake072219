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

public class Homing_rocket extends Enemy implements Animatable, Interactable {

    private Point2D heading;
    private static Random rnd = new Random();

    public Homing_rocket() {
        super(-20, -10);

        setImage(Globals.getInstance().getImage("Enemy2"));
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);

        double direction = rnd.nextDouble() * 1;
        setRotate(direction);

        int speed = 2;
        heading = Utils.directionToVector(direction, speed);
    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            heading = Utils.directionToVector(getRotate() - 60, 2);
            setRotate(getRotate() - 60);
        }

        List<Snake> snakes = new ArrayList<>();
        snakes.add(Globals.getInstance().snake);
        snakes.add(Globals.getInstance().snake2);
        int index = rnd.nextInt(snakes.size());
        snakes.get(index).getHead();

        double dir = Utils.getDirectionBetweenTwo(this, getClosestSnake());
        setRotate(dir);
        double speed = 1;
        heading = Utils.directionToVector(dir, speed);

        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    public SnakeHead getClosestSnake() {

        List<Snake> snakes = new ArrayList<>();
        snakes.add(Globals.getInstance().snake);
        snakes.add(Globals.getInstance().snake2);
        List<Double> distances = new ArrayList<>();

        for (Snake snake : snakes) {
            double deltaX = snake.getHead().getX() - getX();
            double deltaY = snake.getHead().getY() - getY();
            double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
            distances.add(distance);
        }
        if (distances.get(0) < distances.get(1)) {
            return Globals.getInstance().snake.getHead();
        } else {
            return Globals.getInstance().snake2.getHead();
        }
    }

    @Override
    public void apply(GameEntity entity) {
        if (entity instanceof SnakeHead) {
            System.out.println(getMessage());
            destroy();
        }

        if (entity instanceof Beam) {
            destroy();
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public String getMessage() {
        return (getDamage() + " damage");
    }
}

