package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            // Perform database operations here
            Person person = new Person("Test cascading3", 30);

            Item item4 = new Item("Test cascading item4");
            Item item5 = new Item("Test cascading item5");
            Item item6 = new Item("Test cascading item6");

            person.addItem(item4);
            person.addItem(item5);
            person.addItem(item6);

            session.save(person);


            session.getTransaction().commit();
        } catch (Exception e) {
            // Handle exceptions here
        }
    }
}

