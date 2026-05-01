package com.ddm.model.board;

import com.ddm.model.entity.Monster;

import java.util.ArrayList;
import java.util.List;

public class Board {
    
    private int size;
    private List<Monster> monsters = new ArrayList<>();

    public Board(int size) {
        this.size = size;
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
}
