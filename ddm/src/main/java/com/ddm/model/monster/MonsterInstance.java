package com.ddm.model.monster;

import com.ddm.model.monster.MonsterTemplate;
import com.ddm.model.player.Player;

public class MonsterInstance {
    
    private MonsterTemplate template;

    private int currentHealth;
    
    private int positionX;
    private int positionY;

    private Player owner;

    public MonsterInstance(
        MonsterTemplate template,
        Player owner
    ) {
        this.template = template;
        this.owner = owner;
        this.currentHealth = template.getHealth();
    }

    public MonsterTemplate getTemplate() {
        return template;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Player getOwner() {
        return owner;
    }
}
