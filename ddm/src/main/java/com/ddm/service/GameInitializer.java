package com.ddm.service;

import com.ddm.model.game.Game;
import com.ddm.model.monster.MonsterTemplate;
import com.ddm.model.player.Player;

import org.hibernate.Session;

import java.util.List;

public class GameInitializer {

    public Game createGame(
            String player1Name,
            String player2Name,
            Session session
    ) {
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        List<MonsterTemplate> monsters = 
            session.createQuery(
                "FROM MonsterTemplate",
                MonsterTemplate.class
            ).list();
        
        for (int i = 0; i < 15; i++) {
            player1.addMonster(monsters.get(i));
            player2.addMonster(monsters.get(i));
        }
        return new Game(player1, player2);
    }
}
