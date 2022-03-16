package com.hibernate.eagerLazy;

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
            System.out.println("$$ Instructor: " + tempInstructor);
            // get courses before session close if not then courses can't be accesssed in LAZY fetch after session closed
            System.out.println("$$ Courses: " + tempInstructor.getCourses());

            // commit transaction
            System.out.println("Session is now closed!!\n");
            session.getTransaction().commit();
            session.close();

            // session closed and now trying to access course data
            System.out.println("$$ Courses: " + tempInstructor.getCourses());
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
