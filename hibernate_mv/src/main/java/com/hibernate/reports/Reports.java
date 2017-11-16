package com.hibernate.reports;

import com.hibernate.entity.Exam;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class Reports {

    public List<ExamResult> getResultExams(String firstname, String secondname, Session session){
        String query = "select new com.hibernate.reports.ExamResult(s.name, st.secondName, e.grade) " +
                "from Exam e, Subject s, Student st " +
                "where e.student.id = st.id and e.subject.id = s.id " +
                "and st.firstName = :firstname and st.secondName = :secondname";
        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("firstname", firstname);
        hibernateQuery.setParameter("secondname", secondname);
        return hibernateQuery.getResultList();
    }

    public List<ExamResult> getResultExamsLight(String firstname, String secondname, Session session){
        String query = "select new com.hibernate.reports.ExamResult(e.subject.name, e.student.secondName, e.grade) " +
                "from Exam e " +
                "where e.student.firstName = :firstname and e.student.secondName = :secondname";
        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("firstname", firstname);
        hibernateQuery.setParameter("secondname", secondname);
        return hibernateQuery.getResultList();
    }

    public  List<Exam> getResultWithCreteria(String firstname, String secondname, Session session){
        Criteria criteria = session.createCriteria(Exam.class);
        criteria.setMaxResults(10);
        criteria.createAlias("student", "s");
        criteria.add(Restrictions.and(
                Restrictions.eq("s.firstName", firstname),
                Restrictions.eq("s.secondName", secondname)

        ));
        return criteria.list();
    }
}
