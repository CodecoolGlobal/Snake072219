package com.codecool.snake;

import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.Snake;

import java.util.List;

import static com.codecool.snake.Globals.getInstance;

public class GameLoop {

    private boolean running = false;

    public GameLoop(Snake snake, Snake snake2) {
        getInstance().snake1 = snake;
        getInstance().snake2 = snake2;
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public void step() {
        if (running) {
            getInstance().display.displayLives();
            getInstance().game.spawnRandomPowerUps();
            getInstance().game.spawnRandomEnemies();
            getInstance().snake1.step();
            getInstance().snake2.step();
            for (GameEntity gameObject : getInstance().display.getObjectList()) {
                if (gameObject instanceof Animatable) {
                    ((Animatable) gameObject).step();
                }
            }
            checkCollisions();
        }

        getInstance().display.frameFinished();
    }

    private void checkCollisions() {
        List<GameEntity> gameObjs = getInstance().display.getObjectList();
        for (int idxToCheck = 0; idxToCheck < gameObjs.size(); ++idxToCheck) {
            GameEntity objToCheck = gameObjs.get(idxToCheck);
            if (objToCheck instanceof Interactable) {
                for (int otherObjIdx = idxToCheck + 1; otherObjIdx < gameObjs.size(); ++otherObjIdx) {
                    GameEntity otherObj = gameObjs.get(otherObjIdx);
                    if (otherObj instanceof Interactable) {
                        if (objToCheck.getBoundsInParent().intersects(otherObj.getBoundsInParent())) {
                            ((Interactable) objToCheck).apply(otherObj);
                            ((Interactable) otherObj).apply(objToCheck);
                        }
                    }
                }
            }
        }
    }
}
