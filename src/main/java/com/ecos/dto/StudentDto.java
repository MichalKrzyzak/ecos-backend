package com.ecos.dto;

import java.util.List;

public class StudentDto {
    private long id;
    private String firstName;
    private String lastName;
    private long peselNumber;
    private int collegeId;
    private FieldOfStudyDto fieldOfStudy;
    private List<GradeDto> grades;
    private boolean isActive;

    public StudentDto() {
    }

    public StudentDto(long id, String firstName, String lastName, long peselNumber, int collegeId, FieldOfStudyDto fieldOfStudy, List<GradeDto> grades, boolean isActive) {
        this.id = id;
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

    public FieldOfStudyDto getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudyDto fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public List<GradeDto> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeDto> grades) {
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
        return "StudentDto{" +
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
