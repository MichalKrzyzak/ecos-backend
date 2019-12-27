package com.ecos.dto;

import com.ecos.model.enums.TeacherRoleEnum;

public class TeacherDto {
    private long id;
    private String firstName;
    private String lastName;
    private long peselNumber;
    private boolean isActive;
    private String teacherRole;
    private FieldOfStudyDto fieldOfStudy;

    public TeacherDto() {
    }

    public TeacherDto(long id, String firstName, String lastName, long peselNumber, boolean isActive, FieldOfStudyDto fieldOfStudy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = peselNumber;
        this.isActive = isActive;
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

    public String getTeacherRole() {
        return teacherRole;
    }

    public void setTeacherRole(String teacherRole) {
        this.teacherRole = teacherRole;
    }

    public FieldOfStudyDto getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudyDto fieldOfStudy) {
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
