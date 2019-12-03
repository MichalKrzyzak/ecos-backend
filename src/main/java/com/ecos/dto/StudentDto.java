package com.ecos.dto;

public class StudentDto {
    private long id;
    private String firstName;
    private String lastName;
    private long peselNumber;
    private int collegeId;
    private FieldOfStudyDto fieldOfStudyDto;
    private boolean isActive;
    private String yearOfStudy;

    public StudentDto() {
    }

    public StudentDto(String firstName, String lastName, long peselNumber, int collegeId, FieldOfStudyDto fieldOfStudy, boolean isActive, String yearOfStudy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = peselNumber;
        this.collegeId = collegeId;
        this.fieldOfStudyDto = fieldOfStudy;
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

    public FieldOfStudyDto getFieldOfStudy() {
        return fieldOfStudyDto;
    }

    public void setFieldOfStudy(FieldOfStudyDto fieldOfStudy) {
        this.fieldOfStudyDto = fieldOfStudy;
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
                ", fieldOfStudy='" + fieldOfStudyDto + '\'' +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
