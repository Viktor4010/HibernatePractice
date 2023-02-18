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
            Person person = new Person("Test person", 30);

            Item newItem = new Item("Item from hibernate 2", person);

            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));


            session.save(person);
            session.save(newItem);

            session.getTransaction().commit();
        } catch (Exception e) {
            // Handle exceptions here
        }
    }
}

