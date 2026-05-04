package com.ddm.model.entity;

public class DungeonMaster {
    
    private Long id;
    private int health;
    private int positionX;
    private int positionY;

    public DungeonMaster(int health, int positionX, int positionY) {
        this.health = health;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void receiveDamage(int damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}
