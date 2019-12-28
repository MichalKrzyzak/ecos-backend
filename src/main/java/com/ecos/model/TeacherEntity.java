package com.ecos.model;

import com.ecos.model.enums.TeacherRoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "Teachers")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEACHER_ID")
    private long id;
    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String firstName;
    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String lastName;
    @Column(nullable = false)
    private long peselNumber;
    @Column(nullable = false)
    private boolean isActive;
    private String teacherRole;

    public TeacherEntity() {

    }

    public TeacherEntity(String firstName, String lastName, long peselNumber, boolean isActive, String teacherRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = peselNumber;
        this.isActive = isActive;
        this.teacherRole = teacherRole;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getTeacherRole() {
        return teacherRole;
    }

    public void setTeacherRole(String teacherRole) {
        this.teacherRole = teacherRole;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", peselNumber=" + peselNumber +
                ", isActive=" + isActive +
                ", teacherRole='" + teacherRole + '\'' +
                '}';
    }
}
