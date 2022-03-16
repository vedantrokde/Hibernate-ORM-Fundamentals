package com.hibernate.CRUD.demo;

import com.hibernate.CRUD.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();

        // use the session object to save Java Object
        try {
            // start a transaction
            session.beginTransaction();

            // fetch one student object
            System.out.println("Fetching student of id 4...");
            Student tempStudent = session.get(Student.class, 4);
            System.out.println("Get complete: " + tempStudent);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
