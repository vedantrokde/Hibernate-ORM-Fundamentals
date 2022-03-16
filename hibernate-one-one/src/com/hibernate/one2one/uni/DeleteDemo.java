package com.hibernate.one2one.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
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

            // fetch instructor on id
            int instructorId = 1;
            Instructor tempInstructor = session.get(Instructor.class, instructorId);
            System.out.println("Found Instructor: " + tempInstructor);

            // delete the instructor and associated instructorDetails
            if(tempInstructor!=null){
                System.out.println("Deleting...");
                session.delete(tempInstructor);
            }

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
