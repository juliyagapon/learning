package com.hibernate;

import com.hibernate.entity.Exam;
import com.hibernate.entity.Student;
import com.hibernate.reports.ExamResult;
import com.hibernate.reports.Reports;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class main {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        /*Student student = new Student();

        student.setFirstName("Rich");
        student.setSecondName("Croid");
        student.setAge(23);
        student.setDateOfUpdate();

        session.save(student);*/

        /*Student student = session.get(Student.class, 1);
        Set<Exam> exams = student.getExam();

        System.out.println(exams);*/

        /*Query query = session.createQuery("from Student");
        List<Student> students = query.getResultList();*/

        Reports reports = new Reports();
        List<ExamResult> examResults = reports.getResultExamsLight("Jack", "Daniels", session);

        //System.out.println(students);
        transaction.commit();



        session.close();
        sessionFactory.close();
    }
}
