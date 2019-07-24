package com.codecool.snake.entities.weapons;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;

public class Beam extends GameEntity implements Interactable {

    public Beam(){
        setImage(Globals.getInstance().getImage("Beam"));



    }

    @Override
    public void apply(GameEntity entity) {
        if(entity instanceof SnakeHead){
            System.out.print(getMessage());

        }


    }

    @Override
    public String getMessage() {
        return  "LAAASER";
    }
}
