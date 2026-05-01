package com.ddm.model.entity;

import com.ddm.enums.MonsterType;
import com.ddm.enums.MovementType;
import com.ddm.model.game.Dice.MonsterDice;
import com.ddm.model.game.Dice.Rune;
public class Monster {
    
    private Long id;

    private String name;

    private int level;

    private MonsterType type;

    private MovementType movementType;

    private int attack;
    private int defense;
    private int health;

    private int position;

    private MonsterDice dice;

    public Monster(
        String name, 
        int level,
        MonsterType type,
        MovementType movementType,
        int attack, 
        int defense, 
        int health, 
        int position,
        MonsterDice dice
    ) {
        this.name = name;
        this.level = level;
        this.type = type;
        this.movementType = movementType;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.position = position;
        this.dice = dice;
    }

    public Rune rollDice() {
        return dice.roll();
    }


    public void receiveDamage(int damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public MonsterType getType() {
        return type;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getPosition() {
        return position;
    }

    public MonsterDice getDice() {
        return dice;
    }

    

}
