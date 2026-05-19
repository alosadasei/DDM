package com.ddm.model.player;

import com.ddm.enums.RuneType;
import com.ddm.model.entity.Monster;
import com.ddm.model.monster.MonsterTemplate;
import com.ddm.model.entity.DungeonMaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    
    private Long id;
    private String name;

    // 1 Dungeon Master
    private DungeonMaster dungeonMaster;

    // 15 monstruos al inicio de la partida
    private List<MonsterTemplate> monsterPool = new ArrayList<>();

    // 3 monstruos que se seleccional al iniciar el turno

    private List<MonsterTemplate> selectedMonsters = new ArrayList<>();

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

    public void addMonster(MonsterTemplate monster) {
        if(monsterPool.size() >= 15) {
            throw new IllegalStateException("Full monster pool");
        }
        monsterPool.add(monster);
    }

    public void selectMonsters(List<MonsterTemplate> monsters) {
        if(monsters.size() != 3) {
            throw new IllegalStateException("Must be exactly 3 monsters");
        }

        for (MonsterTemplate monster : monsters) {
            if(!monsterPool.contains(monster)){
                throw new IllegalStateException("Monster not in player's pool");
            }
        }
        selectedMonsters = monsters;
    }

    public List<MonsterTemplate> getSelectedMonsters() {
        return selectedMonsters;
    }

    public List<MonsterTemplate> getMonsterPool() {
        return monsterPool;
    }

    public void setDungeonMaster(DungeonMaster dm) {
        this.dungeonMaster = dm;
    }

    public DungeonMaster getDungeonMaster() {
        return dungeonMaster;
    }

    public String getName() {
        return name;
    }
}
