package com.ddm.model.game;

import com.ddm.enums.RuneType;

import java.util.Random;

public class RuneDice {

    private static final RuneType[] faces = RuneType.values();
    private static final Random random = new Random();

    public RuneType roll() {
        return faces[random.nextInt(faces.length)];
    }
}
