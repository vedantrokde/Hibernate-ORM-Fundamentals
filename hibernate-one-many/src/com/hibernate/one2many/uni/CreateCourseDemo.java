package com.hibernate.one2many.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {
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

            // create objects
            int instructorId = 3;
            Instructor tempInstructor = session.get(Instructor.class, instructorId);
            Course tempCourse1 = new Course("Software Engineering");
            Course tempCourse2 = new Course("Cybersecurity");

            // add course objects to instructor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            // save courses
            System.out.println("Creating new object...");
            session.save(tempCourse1);
            session.save(tempCourse2);

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
