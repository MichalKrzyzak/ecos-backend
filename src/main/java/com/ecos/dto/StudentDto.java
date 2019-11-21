package com.ecos.dto;

public class StudentDto {
    private long id;
    private String firstName;
    private String lastName;
    private long peselNumber;
    private int collegeId;
    private String fieldOfStudy;
    private boolean isActive;

    public StudentDto() {
    }

    public StudentDto(String firstName, String lastName, long peselNumber, int collegeId, String fieldOfStudy, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = peselNumber;
        this.collegeId = collegeId;
        this.fieldOfStudy = fieldOfStudy;
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