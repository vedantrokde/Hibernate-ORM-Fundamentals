package com.hibernate.CRUD.demo;

import com.hibernate.CRUD.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
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

            // Fetch a student object and delete
            // int studentId = 1;
            // Student tempStudent = session.get(Student.class, studentId);
            // System.out.println("Deleting student: " + tempStudent);
            // session.delete(tempStudent);

            // Query to delete a student
            session.createQuery("delete from Student where id=2").executeUpdate();

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Updated data successfully...");
        } finally {
            factory.close();
        }
    }
}
