package com.hibernate.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "secondname")
    private String secondName;

    @Column(name = "age")
    private int age;

    @Column(name = "dateofupdate")
    private Date dateOfUpdate;

    @Embedded
    private StudentAddress studentAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private Set<Exam> exams;

    public Set<Exam> getExam() {
        return exams;
    }

    public void setExam(Set<Exam> exams) {
        this.exams = exams;
    }

    public int getId() {
        return id;
    }

    public void setIdStudent(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate() {
        Date dateOfUpdate = new Date();
        this.dateOfUpdate = dateOfUpdate;
    }

    public StudentAddress getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(StudentAddress studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", dateOfUpdate=" + dateOfUpdate +
                ", studentAddress=" + studentAddress +
                '}';
    }
}