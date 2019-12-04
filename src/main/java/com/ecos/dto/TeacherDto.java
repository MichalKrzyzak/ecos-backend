package com.ecos.dto;

import com.ecos.model.FieldOfStudyEntity;
import com.ecos.model.enums.TeacherRoleEnum;

public class TeacherDto {
    private long id;
    private String firstName;
    private String lastName;
    private long peselNumber;
    private boolean isActive;
    private TeacherRoleEnum teacherRole;
    private FieldOfStudyEntity fieldOfStudy;

    public TeacherDto() {
    }

    public TeacherDto(long id, String firstName, String lastName, long peselNumber, boolean isActive, TeacherRoleEnum teacherRole, FieldOfStudyEntity fieldOfStudy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = peselNumber;
        this.isActive = isActive;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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

    @Override
    public String toString() {
        return "TeacherDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", peselNumber=" + peselNumber +
                ", isActive=" + isActive +
                ", teacherRole=" + teacherRole +
                ", fieldOfStudy=" + fieldOfStudy +
                '}';
    }
}
