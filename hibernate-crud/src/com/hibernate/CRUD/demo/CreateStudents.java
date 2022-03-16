package com.hibernate.CRUD.demo;

import com.hibernate.CRUD.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudents {
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
            System.out.println("Creating 3 Student object...");
            Student tempStudent1 = new Student("Ram", "G", "ram.g@hibernate.com");
            Student tempStudent2 = new Student("Buland", "Prasad", "buland.prasad@hibernate.com");
            Student tempStudent3 = new Student("Shubham", "Lala", "shubham.lala@hibernate.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Saved data successfully...");
        } finally {
            factory.close();
        }

    }
}
