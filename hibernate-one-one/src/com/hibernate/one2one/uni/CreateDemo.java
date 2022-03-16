package com.hibernate.one2one.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
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
            // create objects
            // Instructor tempInstructor = new Instructor("Chad", "Darby", "chad.darby@hibernate.com");
            // InstructorDetail tempInstructorDetails = new InstructorDetail("youtube.com", "coding");

            Instructor tempInstructor = new Instructor("Shyam", "Pande", "shyam.oande@hibernate.com");
            InstructorDetail tempInstructorDetails = new InstructorDetail("youtube.com", "singing");

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
            System.out.println("Saved data successfully...");
        } finally {
            factory.close();
        }
    }
}
