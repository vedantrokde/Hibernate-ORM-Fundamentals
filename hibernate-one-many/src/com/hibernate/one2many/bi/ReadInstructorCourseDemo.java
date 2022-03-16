package com.hibernate.one2many.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadInstructorCourseDemo {
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
            // start a transaction
            session.beginTransaction();

            // fetch objects
            int instructorId = 1;
            Instructor tempInstructor = session.get(Instructor.class, instructorId);
            
            // get courses
            System.out.println("Courses: " + tempInstructor.getCourses());

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
