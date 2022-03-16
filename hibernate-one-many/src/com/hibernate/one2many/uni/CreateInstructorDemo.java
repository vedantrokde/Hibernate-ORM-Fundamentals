package com.hibernate.one2many.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();

        // use the session object to save Java Object
        try {
            // create objects
            Instructor tempInstructor = new Instructor("Shubham", "Lala", "shuabhm.lala@hibernate.com");
            InstructorDetail tempInstructorDetails = new InstructorDetail("youtube.com", "reading");

            // associate objects
            tempInstructor.setInstructorDetails(tempInstructorDetails);

            // start a transaction
            session.beginTransaction();

            // save the Instructor object
            // NOTE: this will also save InstructorDetails object because of CascaseType.ALL
            System.out.println("Creating new object...");
            session.save(tempInstructor);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // remove session leak
            session.close();
            factory.close();
        }
    }
}
