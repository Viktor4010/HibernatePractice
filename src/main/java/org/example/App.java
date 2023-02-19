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


//            // save
//            Person person = new Person("Test Person3", 50);
//            Passport passport = new Passport( 9876);
//
//            person.setPassport(passport);
//
//            session.save(person);
//
//            // get
//            Person person2 = session.get(Person.class, 1);
//            System.out.println(person.getPassport().getPassportNumber());
//
//            Passport passport3 = session.get(Passport.class, 2);
//            System.out.println(passport.getPerson().getName());
//
//            // update
//            Person person = session.get(Person.class, 3);
//            person.getPassport().setPassportNumber(77777);

//            //delete
//
//            Person person = session.get(Person.class, 2);
//            session.remove(person);

            session.getTransaction().commit();
        } catch (Exception e) {
            // Handle exceptions here
        }
    }
}

