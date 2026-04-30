package com.ddm.model.entity;

public class Monster {
    
    private Long id;
    private String name;

    private int attack;
    private int defense;
    private int health;

    private int position;

    public Monster(String name, int attack, int defense, int health, int position) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.position = position;
    }

    public void receiveDamage(int damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
