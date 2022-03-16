package com.hibernate.CRUD.demo;

import java.util.List;

import com.hibernate.CRUD.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudent {
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
            System.out.println("\n\n");

            // query get all students
            System.out.println("List of all students in DB:");
            @SuppressWarnings("unchecked")
            List<Student> students = session.createQuery("from Student").list();
            displayStudents(students);

            // query students: lastName='G'
            // System.out.println("\nList of all students in DB with lastname=G:");
            // @SuppressWarnings("unchecked")
            // List<Student> students = session.createQuery("from Student s where s.lastName='G'").list();
            // displayStudents(students);

            // query students: lastName='G' or firstName="Buland"
            // System.out.println("\nList of all students in DB with lastname=G or firstName='Buland':");
            // @SuppressWarnings("unchecked")
            // List<Student> students = session.createQuery("from Student s where s.lastName='G'" + "OR s.firstName='Buland'").list();
            // displayStudents(students);

            // query students: email LIKE '%hibernate.com'
            // System.out.println("\nList of all students in DB with email LIKE '%hibernate.com'");
            // @SuppressWarnings("unchecked")
            // List<Student> students = session.createQuery("from Student s where s.email LIKE '%hibernate.com'").list();
            // displayStudents(students);

            // commit transaction
            System.out.println("\n\n");
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
