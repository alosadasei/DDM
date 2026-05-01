package com.ddm.model.entity;

public class DungeonMaster {
    
    private Long id;
    private int health;
    private int position;

    public DungeonMaster(int health, int position) {
        this.health = health;
        this.position = position;
    }

    public void receiveDamage(int damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}
