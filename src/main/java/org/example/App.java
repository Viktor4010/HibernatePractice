package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
            Person person = session.get(Person.class, 2);

            Item newItem = new Item("Item from Hibernate", person);

            // make mutal relations
            // this line does not make any sql queries.
            // It is a good practice and help hibernate save actual cash
            person.getItems().add(newItem);

            session.save(newItem);

            session.getTransaction().commit();
        } catch (Exception e) {
            // Handle exceptions here
        }
    }
}

