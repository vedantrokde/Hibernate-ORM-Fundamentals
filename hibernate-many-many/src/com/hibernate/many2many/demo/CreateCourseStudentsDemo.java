package com.hibernate.many2many.demo;

import com.hibernate.many2many.model.Course;
import com.hibernate.many2many.model.Instructor;
import com.hibernate.many2many.model.InstructorDetail;
import com.hibernate.many2many.model.Review;
import com.hibernate.many2many.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseStudentsDemo {
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

            // create and save course
            Course tempCourse = new Course("Pacman - How to score a million");
            session.save(tempCourse);
            System.out.println("Created new course...");

            // add reviews to course
            Student tempStudent1 = new Student("Amit", "Yadav", "amit.yadav@hibernate.com"); 
            Student tempStudent2 = new Student("Ajay", "Ram", "ajay.ram@hibernate.com");
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            // save students
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Added student...");

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
