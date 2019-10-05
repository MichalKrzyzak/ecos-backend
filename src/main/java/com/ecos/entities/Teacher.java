package com.ecos.entities;

import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String firstName;
    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String lastName;
    private String peselNumber;
    private String identityNumber;
    private String subject;
    @OneToOne(cascade = {CascadeType.ALL})
    private Salary salary;

    private Teacher(TeacherBuilder teacherBuilder) {
        this.firstName = teacherBuilder.firstName;
        this.lastName = teacherBuilder.lastName;
        this.peselNumber = teacherBuilder.peselNumber;
        this.identityNumber = teacherBuilder.identityNumber;
        this.subject = teacherBuilder.subject;
        this.salary = teacherBuilder.salary;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(String peselNumber) {
        this.peselNumber = peselNumber;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public static class TeacherBuilder {
        private String firstName;
        private String lastName;
        private String peselNumber;
        private String identityNumber;
        private String subject;
        private Salary salary;

        public TeacherBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TeacherBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TeacherBuilder peselNumber(String peselNumber) {
            this.peselNumber = peselNumber;
            return this;
        }

        public TeacherBuilder identityNumber(String identityNumber) {
            this.identityNumber = identityNumber;
            return this;
        }

        public TeacherBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public TeacherBuilder salary(Salary salary) {
            this.salary = salary;
            return this;
        }

        public Teacher build() {
            return new Teacher(this);
        }
    }
}
