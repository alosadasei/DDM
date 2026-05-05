package com.ddm.model.monster;

import java.util.ArrayList;
import java.util.List;

import com.ddm.enums.MonsterType;
import com.ddm.enums.MovementType;
import com.ddm.model.game.Dice.DiceFace;

import jakarta.persistence.*;

@Entity
@Table(name = "monster_templates")
public class MonsterTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MonsterType monsterType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovementType movementType;

    @Column(nullable = false)
    private int health;

    @Column(nullable = false)
    private int attack;

    @Column(nullable = false)
    private int defense;

    @Column(length = 2000)
    private String description;

    @OneToMany(
        mappedBy = "monsterTemplate",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @OrderBy("faceIndex ASC")
    private List<DiceFace> diceFaces = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "active_ability_id")
    private Ability activeAbility;

    @ManyToOne
    @JoinColumn(name = "passive_ability_id")
    private Ability passiveAbility;

    public MonsterTemplate(){}

    public MonsterTemplate(
        String name,
        MonsterType monsterType,
        MovementType movementType,
        int health,
        int attack,
        int defense,
        String description
    ) {
        this.name = name;
        this.monsterType = monsterType;
        this.movementType = movementType;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.description = description;
    }

    public void addDiceFace(DiceFace face) {
        if(diceFaces.size() >= 6) {
            throw new IllegalStateException("A monster dice cannot have more than 6 faces");
        }
        face.setMonsterTemplate(this);
        diceFaces.add(face);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<DiceFace> getDiceFaces() {
        return diceFaces;
    }

    public Ability getActiveAbility() {
        return activeAbility;
    }

    public Ability getPassiveAbility() {
        return passiveAbility;
    }
}
