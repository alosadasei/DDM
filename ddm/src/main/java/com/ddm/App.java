package com.ddm;

import com.ddm.config.HibernateUtil;
import org.hibernate.Session;
public class App 
{
    public static void main( String[] args )
    {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Hibernate se ha conectado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
