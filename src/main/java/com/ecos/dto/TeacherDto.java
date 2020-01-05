package com.ecos.dto;

public class TeacherDto {
    private long id;
    private String firstName;
    private String lastName;
    private long peselNumber;
    private FieldOfStudyDto fieldOfStudy;
    private boolean isActive;

    public TeacherDto() {
    }

    public TeacherDto(long id, String firstName, String lastName, long peselNumber, FieldOfStudyDto fieldOfStudy, boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = peselNumber;
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

    public FieldOfStudyDto getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudyDto fieldOfStudy) {
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
        return "TeacherDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", peselNumber=" + peselNumber +
                ", fieldOfStudy=" + fieldOfStudy +
                ", isActive=" + isActive +
                '}';
    }
}
