package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;

public abstract class Enemy extends GameEntity{
    private final int damage;
    private final int speed;


    public Enemy(int damage,int speed) {
        this.damage = damage;
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }
}
