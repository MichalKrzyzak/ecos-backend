package com.ecos.model;

import javax.persistence.*;

@Entity
@Table(name = "Students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String firstName;
    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String lastName;
    @Column(nullable = false)
    private long peselNumber;
    @Column(nullable = false)
    private int collegeId;
    private String fieldOfStudy;
    private boolean isActive;

    private String yearOfStudy;

    public StudentEntity() {
    }

    public StudentEntity(String firstName, String lastName, long peselNumber, int collegeId, String fieldOfStudy, boolean isActive, String yearOfStudy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = peselNumber;
        this.collegeId = collegeId;
        this.fieldOfStudy = fieldOfStudy;
        this.isActive = isActive;
        this.yearOfStudy = yearOfStudy;
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

    public long getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(long peselNumber) {
        this.peselNumber = peselNumber;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", peselNumber='" + peselNumber + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
