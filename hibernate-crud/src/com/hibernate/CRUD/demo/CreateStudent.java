package com.hibernate.CRUD.demo;

import com.hibernate.CRUD.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
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
            // create a student object
            System.out.println("Creating new Student object...");
            Student tempStudent = new Student("Abdul", "Khan", "abdul.khan@hibernate.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving new student...");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Saved data successfully...");
        } finally {
            factory.close();
        }
    }
}
