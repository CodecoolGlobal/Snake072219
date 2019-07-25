package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.snakes.Snake;
import com.codecool.snake.resources.Resources;
import javafx.scene.image.Image;

import java.util.Collections;
import java.util.List;

// class for holding all static stuff
public class Globals {
    private static Globals instance = null;

    public static final double WINDOW_WIDTH = 1000;
    public static final double WINDOW_HEIGHT = 700;

    public Display display;
    public Game game;
    public Snake snake;
    public Snake snake2;


    private GameLoop gameLoop;
    private Resources resources;


    public static Globals getInstance() {
        if (instance == null) instance = new Globals();
        return instance;
    }

    public void setGameLoop(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    public void setupResources() {
        resources = new Resources();
        resources.addImage("SnakeHead", new Image("snake_headBLUE.png"));
        resources.addImage("SnakeBody", new Image("snake_bodyBLUE.png"));
        resources.addImage("Bouncer_enemy", new Image("worm_enemy.gif"));
        resources.addImage("Enemy2", new Image("homing.gif"));
        resources.addImage("PowerUpBerry", new Image("powerup_berry.png"));
        resources.addImage("PowerUpNut", new Image("powerup_nut.png"));
        resources.addImage("PowerUpCombined", new Image("powerup_combined.png"));
        resources.addImage("zerolife", new Image("0.png"));
        resources.addImage("onelife", new Image("1.png"));
        resources.addImage("twolifes", new Image("2.png"));
        resources.addImage("threelifes", new Image("3.png"));
        resources.addImage("fourlifes", new Image("4.png"));
        resources.addImage("Beam", new Image("laserc.gif"));

    }

    public Image getImage(String name) {
        return resources.getImage(name);
    }

    public void startGame() {
        gameLoop.start();
    }

    public void stopGame() {
        gameLoop.stop();
    }

    public static List<GameEntity> gameObjects;

    public static List<GameEntity> getGameObjects() {
        return Collections.unmodifiableList(gameObjects);
    }

    private Globals() {
        // singleton needs the class to have private constructor
    }
}
