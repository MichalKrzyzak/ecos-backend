package com.ecos.model;

import com.ecos.model.enums.TeacherRoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "Teachers")
public class TeacherEntity {
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
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    private TeacherRoleEnum teacherRole;
    @ManyToOne
    private FieldOfStudyEntity fieldOfStudy;

    public TeacherEntity() {
    }

    public TeacherEntity(String firstName, String lastName, long peselNumber, TeacherRoleEnum teacherRole, FieldOfStudyEntity fieldOfStudy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = peselNumber;
        this.teacherRole = teacherRole;
        this.fieldOfStudy = fieldOfStudy;
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

    public TeacherRoleEnum getTeacherRole() {
        return teacherRole;
    }

    public void setTeacherRole(TeacherRoleEnum teacherRole) {
        this.teacherRole = teacherRole;
    }

    public FieldOfStudyEntity getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudyEntity fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", peselNumber=" + peselNumber +
                ", teacherRole=" + teacherRole +
                ", fieldOfStudy=" + fieldOfStudy +
                '}';
    }
}
