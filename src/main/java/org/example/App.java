package org.example;

import org.example.model.Passport;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            // Perform database operations here

            Person person = new Person("Test Person2", 50);
            Passport passport = new Passport(person, 56789);

            person.setPassport(passport);

            session.save(person);

            session.getTransaction().commit();
        } catch (Exception e) {
            // Handle exceptions here
        }
    }
}

