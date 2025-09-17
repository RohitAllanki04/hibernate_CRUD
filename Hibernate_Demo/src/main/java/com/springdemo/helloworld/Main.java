package com.springdemo.helloworld;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        allien a1 = new allien();
        a1.setId(20);
        a1.setName("a1");
        a1.setTech("js");

        allien a4 = new allien();
        a4.setId(21);
        a4.setName("a2");
        a4.setTech("react");

        allien a5 = new allien();
        a5.setId(22);
        a5.setName("a3");
        a5.setTech("vs");

        Configuration config = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(allien.class);

        SessionFactory factory = config.buildSessionFactory();

        // ---- Insert ----
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(a1);
        session.persist(a4);
        session.persist(a5);
        tx.commit();
        session.close();

        // ---- Fetch ----
        session = factory.openSession();
        tx = session.beginTransaction();
        allien fetched = session.find(allien.class, 20);
        tx.commit();
        System.out.println("Fetched: " + fetched);
        session.close();

        // ---- Update ----
        session = factory.openSession();
        tx = session.beginTransaction();
        a5.setTech("Visual Studio");
        session.merge(a5);
        tx.commit();
        session.close();

        // ---- Delete ----
        session = factory.openSession();
        tx = session.beginTransaction();
        session.remove(a4);
        tx.commit();
        session.close();

        // Always close the factory last
        factory.close();
    }
}
