package com.ddm.model.entity;

import com.ddm.model.player.Player;

public class DungeonMaster {
    
    private Player owner;

    private int health = 100;

    private int positionX;
    private int positionY;

    public DungeonMaster(Player owner, int x, int y) {
        this.owner = owner;
        this.positionX = x;
        this.positionY = y;
    }

    public Player getOwner() {
        return owner;
    }

    public int getHealth() {
        return health;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
