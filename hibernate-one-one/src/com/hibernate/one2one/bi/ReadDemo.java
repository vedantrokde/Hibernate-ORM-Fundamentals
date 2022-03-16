package com.hibernate.one2one.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        // use the session object to save Java Object
        try {
            // start a transaction
            session.beginTransaction();
            
            // fetch instructor detail using id
            int instructorDetailId = 36;
            InstructorDetail tempInstructor = session.get(InstructorDetail.class, instructorDetailId);

            // print objects
            System.out.println("Instructor Details: " + tempInstructor);
            System.out.println("Associated Instructor: " + tempInstructor.getInstructor());

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // handle connection leak
            session.close();
            factory.close();
        }
    }
}
