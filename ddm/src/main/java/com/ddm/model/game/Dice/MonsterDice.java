package com.ddm.model.game.Dice;

import java.util.List;
import java.util.Random;

public class MonsterDice {
    
    private List<DiceFace> faces;
    private static final Random random = new Random();

    public MonsterDice(List<DiceFace> faces) {
        this.faces = faces;
    }

    public Rune roll() {
        int index = random.nextInt(faces.size());
        return faces.get(index).getRune();
    }
}
