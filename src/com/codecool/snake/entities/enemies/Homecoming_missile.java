package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;

import java.util.List;
import java.util.Random;

public class Homecoming_missile extends Enemy implements Animatable, Interactable {

    private Point2D heading;
    private static Random rnd = new Random();
//    private List<Float> angle_directions;

    public Homecoming_missile(){
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
        double dir = Utils.getDirectionBetweenTwo(this, Globals.getInstance().snake.getHead());
//        double dir_snake2 = Utils.getDirectionBetweenTwo(this, Globals.getInstance().snake2.getHead());

//        angle_directions.add((float) dir_snake);
//        angle_directions.add((float) dir_snake2);
//        Random rand = new Random();
//        float randomAngle = angle_directions.get(rand.nextInt(angle_directions.size()));
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

