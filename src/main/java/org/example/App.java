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
            Person person = new Person("Test cascading", 30);

            Item item = new Item("Test cascading item",person);

            person.setItems(new ArrayList<>(Collections.singletonList(item)));

            session.persist(person);


            session.getTransaction().commit();
        } catch (Exception e) {
            // Handle exceptions here
        }
    }
}

