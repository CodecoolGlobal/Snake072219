package com.codecool.snake.entities.snakes;

import com.codecool.snake.DelayedModificationList;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.eventhandler.InputHandler;

import com.sun.javafx.geom.Vec2d;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;

public class Snake implements Animatable {
    private static final float speed = 2;
    private int health = 100;
    private String player;

    private SnakeHead head;

    private DelayedModificationList<GameEntity> body;

    public Snake(Vec2d position, String player) {
        head = new SnakeHead(this, position);
        body = new DelayedModificationList<>();
        this.player = player;
        addPart(4);
    }

    public SnakeHead getHead() {
        return head;
    }

    public void step() {

        SnakeControl turnDir = getUserInput(this.player);
        if (turnDir.equals(SnakeControl.SHOOT)) {
            System.out.println("shoot");
        } else {
            head.updateRotation(turnDir, speed);
        }
        updateSnakeBodyHistory();
        checkForGameOverConditions();

        body.doPendingModifications();
    }

    private SnakeControl getUserInput(String player) {
        if (player.equals("Player1")) {
            SnakeControl turnDir = SnakeControl.INVALID;
            if (InputHandler.getInstance().isKeyPressed(KeyCode.A)) turnDir = SnakeControl.TURN_LEFT;
            if (InputHandler.getInstance().isKeyPressed(KeyCode.D)) turnDir = SnakeControl.TURN_RIGHT;
            if (InputHandler.getInstance().isKeyPressed(KeyCode.SHIFT)) turnDir = SnakeControl.SHOOT;
            return turnDir;

        } else {
            SnakeControl turnDir = SnakeControl.INVALID;
            if (InputHandler.getInstance().isKeyPressed(KeyCode.LEFT)) turnDir = SnakeControl.TURN_LEFT;
            if (InputHandler.getInstance().isKeyPressed(KeyCode.RIGHT)) turnDir = SnakeControl.TURN_RIGHT;
            return turnDir;
        }
    }

    public void addPart(int numParts) {
        GameEntity parent = getLastPart();
        Vec2d position = parent.getPosition();

        for (int i = 0; i < numParts; i++) {
            SnakeBody newBodyPart = new SnakeBody(position);
            body.add(newBodyPart);
        }
        Globals.getInstance().display.updateSnakeHeadDrawPosition(head);
    }

    public void changeHealth(int diff) {
        health += diff;
        System.out.println(health);
    }

    public int getHealth() {
        return health;
    }

    private void checkForGameOverConditions() {
        if (head.isOutOfBounds() || health <= 0) {
            System.out.println("Game Over");
            gameOverPopUp();
        }
    }

    //this could go somewhere else
    public void gameOverPopUp() {
        if (!Globals.getInstance().game.alreadyExecuted) {
            Globals.getInstance().game.alreadyExecuted = true;
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText("Player 1 Score: " + Globals.getInstance().snake.body.getList().size() +
                    "\n" + "Player 2 Score: " + Globals.getInstance().snake2.body.getList().size());
            alert.setContentText("Choose your option");
            ButtonType restart = new ButtonType("Restart");
            alert.getButtonTypes().setAll(restart, ButtonType.CLOSE);
            Globals.getInstance().stopGame();

        alert.setOnHidden(evt -> {
            if (alert.getResult() == ButtonType.CLOSE) {
                Platform.exit();
                System.exit(0);
            } else {
                System.out.println("Restarting");
                gameRestart();
            }
        });
        alert.show();
    }

    //this could go somewhere else
    private void gameRestart() {
        Globals.getInstance().display.clear();
        Globals.getInstance().game.init();
        Globals.getInstance().startGame();
    }


    private void updateSnakeBodyHistory() {
        GameEntity prev = head;
        for (GameEntity currentPart : body.getList()) {
            currentPart.setPosition(prev.getPosition());
            prev = currentPart;
        }
    }

    private GameEntity getLastPart() {
        GameEntity result = body.getLast();

        if (result != null) return result;
        return head;
    }
}
