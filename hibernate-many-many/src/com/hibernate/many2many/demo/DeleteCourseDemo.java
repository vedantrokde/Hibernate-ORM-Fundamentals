package com.hibernate.many2many.demo;

import com.hibernate.many2many.model.Course;
import com.hibernate.many2many.model.Instructor;
import com.hibernate.many2many.model.InstructorDetail;
import com.hibernate.many2many.model.Review;
import com.hibernate.many2many.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();

        // use the session object to save Java Object
        try {
            // start a transaction
            session.beginTransaction();

            // fetching student
            int courseId = 10;
            Course tempCourse = session.get(Course.class, courseId);
            System.out.println("\nCourse: " + tempCourse);
            System.out.println("Students: " + tempCourse.getStudents());
            
            // delete course
            session.delete(tempCourse);
            System.out.println("Course deleted sucessfully");
            
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
