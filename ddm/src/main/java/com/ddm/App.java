package com.ddm;

import com.ddm.config.HibernateUtil;
import com.ddm.model.game.Game;
import com.ddm.service.GameInitializer;

import org.hibernate.Session;
public class App 
{
    public static void main( String[] args )
    {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            GameInitializer initializer = new GameInitializer();
            Game game = initializer.createGame("DaiQuester", "com", session);

            System.out.println(game.getCurrentPlayerName() + "\'s turn: " + game.getTurnNumber());
            game.nextTurn();
            System.out.println(game.getCurrentPlayerName() + "\'s turn: " + game.getTurnNumber());
        }
    }
}
