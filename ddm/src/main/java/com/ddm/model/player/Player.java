package com.ddm.model.player;

import com.ddm.enums.RuneType;

import java.util.HashMap;
import java.util.Map;

public class Player {
    
    private Long id;
    private String name;

    // Runas acumuladas
    private Map<RuneType, Integer> runePool = new HashMap<>();

    public Player(String name){
        this.name = name;
        initRunes();
    }

    private void initRunes() {
        for (RuneType rune: RuneType.values()) {
            runePool.put(rune, 0);
        }
    }

    public void addRunes(RuneType rune, int amount) {
        runePool.put(rune, runePool.get(rune) + amount);
    }

    public boolean consumeRunes(RuneType rune, int amount) {
        int current = runePool.get(rune);
        if(current >= amount) {
            runePool.put(rune, current - amount);
            return true;
        }
        return false;
    }

    public Map<RuneType, Integer> getRunePool() {
        return runePool;
    }
}
