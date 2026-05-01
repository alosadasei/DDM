package com.ddm.model.game.Dice;

import com.ddm.enums.RuneType;

public class Rune {
    
    private RuneType type;
    private int amount;
    // sólo para invocación
    private Integer level;

    public Rune(RuneType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public Rune(RuneType type, int amount, int level) {
        this.type = type;
        this.amount = amount;
        this.level = level;
    }

    public RuneType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public Integer getLevel() {
        return level;
    }

    public boolean isInvocation() {
        return type == RuneType.INVOCATION;
    }
}
