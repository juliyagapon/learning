package com.hibernate.reports;

public class ExamResult {

    private String secondname;
    private String subjectname;
    private int grade;

    public ExamResult(String subjectname, String secondname, int grade) {
        this.secondname = secondname;
        this.subjectname = subjectname;
        this.grade = grade;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
