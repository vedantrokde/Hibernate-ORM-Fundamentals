package com.hibernate.one2many.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadCourseReviewsDemo {
    public static void main(String[] args) {
        
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();

        // use the session object to save Java Object
        try {
            // start a transaction
            session.beginTransaction();

            // create objects
            int courseId = 10;
            Course tempCourse = session.get(Course.class, courseId);

            // printing the course and reviews
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            
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
