package com.ddm;

import com.ddm.config.HibernateUtil;
import com.ddm.seed.DatabaseSeeder;

import org.hibernate.Session;
public class App 
{
    public static void main( String[] args )
    {
        DatabaseSeeder.seed();
    }
}
