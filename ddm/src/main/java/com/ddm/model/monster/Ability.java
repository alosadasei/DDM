package com.ddm.model.monster;

import com.ddm.enums.RuneType;

import jakarta.persistence.*;

@Entity
@Table(name = "abilities")
public class Ability {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RuneType runeType;

    @Column(nullable = false)
    private int runeCost;

    public Ability() {}

    public Ability(
        String name,
        String description,
        RuneType runeType,
        int runeCost
    ) {
        this.name = name;
        this.description = description;
        this.runeType = runeType;
        this.runeCost = runeCost;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RuneType getRuneType() {
        return runeType;
    }
    
    public int getRuneCost() {
        return runeCost;
    }

    public String getDescription() {
        return description;
    }
}
