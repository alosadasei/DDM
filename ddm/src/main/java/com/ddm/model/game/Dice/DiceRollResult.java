package com.ddm.model.game.Dice;

import com.ddm.enums.RuneType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DiceRollResult {

    private List<Rune> results = new ArrayList<>();

    public void addResult(Rune rune) {
        results.add(rune);
    }

    public List<Rune> getResults() {
        return results;
    }

    // agrupar runas por tipo
    public Map<RuneType, Integer> getTotalRunes() {
        return results.stream()
                .collect(Collectors.groupingBy(
                        Rune::getType,
                        Collectors.summingInt(Rune::getAmount)
                ));
    }

    // invocaciones agrupadas por nivel
    public Map<Integer, Long> getInvocationByLevel() {
        return results.stream()
                .filter(Rune::isInvocation)
                .collect(Collectors.groupingBy(
                        Rune::getLevel,
                        Collectors.counting()
                ));
    }
}