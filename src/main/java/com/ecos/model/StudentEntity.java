package com.ecos.model;

import javax.persistence.*;
import java.util.List;

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
    @Column(nullable = false, name = "COLLEGE_ID")
    private int collegeId;
    @ManyToOne
    private FieldOfStudyEntity fieldOfStudy;
    @OneToMany
    private List<GradeEntity> grades;
    private boolean isActive;

    public StudentEntity() {
    }

    public StudentEntity(String firstName, String lastName, long peselNumber, int collegeId, FieldOfStudyEntity fieldOfStudy, List<GradeEntity> grades, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = peselNumber;
        this.collegeId = collegeId;
        this.fieldOfStudy = fieldOfStudy;
        this.grades = grades;
        this.isActive = isActive;
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

    public FieldOfStudyEntity getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudyEntity fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public List<GradeEntity> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeEntity> grades) {
        this.grades = grades;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", peselNumber=" + peselNumber +
                ", collegeId=" + collegeId +
                ", fieldOfStudy=" + fieldOfStudy +
                ", grades=" + grades +
                ", isActive=" + isActive +
                '}';
    }
}
