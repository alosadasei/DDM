package com.ddm.model.player;

import com.ddm.enums.RuneType;
import com.ddm.model.entity.Monster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    
    private Long id;
    private String name;

    // 15 monstruos al inicio de la partida
    private List<Monster> monsterPool = new ArrayList<>();

    // 3 monstruos que se seleccional al iniciar el turno

    private List<Monster> selectedMonsters = new ArrayList<>();

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

    public void addMonster(Monster monster) {
        if(monsterPool.size() >= 15) {
            throw new IllegalStateException("Full monster pool");
        }
        monsterPool.add(monster);
    }

    public void selectMonsters(List<Monster> monsters) {
        if(monsters.size() != 3) {
            throw new IllegalStateException("Must be exactly 3 monsters");
        }

        for (Monster monster : monsters) {
            if(!monsterPool.contains(monster)){
                throw new IllegalStateException("Monster not in player's pool");
            }
        }
        selectedMonsters = monsters;
    }

    public List<Monster> getSelectedMonsters() {
        return selectedMonsters;
    }

    public List<Monster> getMonsterPool() {
        return monsterPool;
    }
}
