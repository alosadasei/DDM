package com.ddm.model.game.Dice;

import com.ddm.enums.RuneType;
import com.ddm.model.monster.MonsterTemplate;

import jakarta.persistence.*;

@Entity
@Table(name = "dice_faces")
public class DiceFace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "face_index", nullable = false)
    private int faceIndex;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RuneType runeType;

    @Column(nullable = false)
    private int runeAmount;

    // solo para la invocación
    private Integer invocationLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="monster_template_id")
    private MonsterTemplate monsterTemplate;

    public DiceFace(){}

    public DiceFace(
        int faceIndex,
        RuneType runeType,
        int runeAmount,
        Integer invocationLevel
    ) {
        this.faceIndex = faceIndex;
        this.runeType = runeType;
        this.runeAmount = runeAmount;
        this.invocationLevel = invocationLevel;
    }

    public Long getId() {
        return id;
    }

    public int getFaceIndex() {
        return faceIndex;
    }

    public RuneType getRuneType() {
        return runeType;
    }

    public int getRuneAmount() {
        return runeAmount;
    }

    public Rune getRune() {
        return new Rune(runeType,runeAmount);
    }

    public Integer getInvocationLevel() {
        return invocationLevel;
    }

    public void setMonsterTemplate(MonsterTemplate monsterTemplate) {
        this.monsterTemplate = monsterTemplate;
    }
}
