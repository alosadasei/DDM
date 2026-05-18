package com.ddm.seed;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ddm.config.HibernateUtil;
import com.ddm.enums.*;
import com.ddm.model.game.Dice.DiceFace;
import com.ddm.model.monster.*;

public class DatabaseSeeder {
    
    public static void seed() {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // habilidad
            // Ability ability = new Ability(
            //     "Holy Heal",
            //     "Increase an ally health by 10",
            //     RuneType.MAGIC,
            //     2
            // );

            // session.persist(ability);

            // monstruo
            // MonsterTemplate monster = new MonsterTemplate(
            //     "Cyclops",
            //     MonsterType.BEAST,
            //     MovementType.GROUND,
            //     10,
            //     20,
            //     10,
            //     "A delicate elf who uses her holy power to protect herself and ease the pain of her allies."
            // );
            // // dado del monstruo
            // monster.addDiceFace(
            //     new DiceFace(0,RuneType.INVOCATION, 1,2)
            // );
            // monster.addDiceFace(
            //     new DiceFace(1,RuneType.INVOCATION, 1,2)
            // );
            // monster.addDiceFace(
            //     new DiceFace(2,RuneType.INVOCATION, 1,2)
            // );
            // monster.addDiceFace(
            //     new DiceFace(3,RuneType.ATTACK, 2,null)
            // );
            // monster.addDiceFace(
            //     new DiceFace(4,RuneType.DEFENSE, 2,null)
            // );
            // monster.addDiceFace(
            //     new DiceFace(5,RuneType.MAGIC, 1,null)
            // );

            //session.persist(monster);
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
