package com.ddm.model.game;

import com.ddm.enums.RuneType;

import java.util.ArrayList;
import java.util.List;

public class DiceRollResult {

    private List<RuneType> results = new ArrayList<>();

    public void addResult(RuneType rune) {
        results.add(rune);
    }

    public long countRune(RuneType rune) {
        return results.stream().filter(r -> r == rune).count();
    }

    public List<RuneType> getResults() {
        return results;
    }
}