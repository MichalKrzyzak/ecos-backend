package com.ecos.dto;

import java.util.List;

public class StudentDto {
    private long id;
    private PersonalDataDto personalData;
    private String email;
    private AddressDto registeredAddress;
    private AddressDto correspondenceAddress;
    private int collegeId;
    private List<FieldOfStudyDto> fieldsOfStudy;
    private List<GradeDto> grades;
    private boolean isActive;

    public StudentDto(long id, PersonalDataDto personalData, String email, AddressDto registeredAddress, AddressDto correspondenceAddress, int collegeId, List<FieldOfStudyDto> fieldsOfStudy, List<GradeDto> grades, boolean isActive) {
        this.id = id;
        this.personalData = personalData;
        this.email = email;
        this.registeredAddress = registeredAddress;
        this.correspondenceAddress = correspondenceAddress;
        this.collegeId = collegeId;
        this.fieldsOfStudy = fieldsOfStudy;
        this.grades = grades;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PersonalDataDto getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalDataDto personalData) {
        this.personalData = personalData;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressDto getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(AddressDto registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public AddressDto getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public void setCorrespondenceAddress(AddressDto correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public List<FieldOfStudyDto> getFieldsOfStudy() {
        return fieldsOfStudy;
    }

    public void setFieldsOfStudy(List<FieldOfStudyDto> fieldsOfStudy) {
        this.fieldsOfStudy = fieldsOfStudy;
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
                ", personalData=" + personalData +
                ", email='" + email + '\'' +
                ", registeredAddress=" + registeredAddress +
                ", correspondenceAddress=" + correspondenceAddress +
                ", collegeId=" + collegeId +
                ", fieldsOfStudy=" + fieldsOfStudy +
                ", grades=" + grades +
                ", isActive=" + isActive +
                '}';
    }
}
