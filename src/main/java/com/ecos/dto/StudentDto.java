package com.ecos.dto;

import com.ecos.model.*;

import java.util.List;

public class StudentDto {
    private Long id;
    private PersonalDataEntity personalData;
    private String email;
    private AddressEntity correspondenceAddress;
    private int collegeId;
    private String yearOfStudy;
    private String studentsGroup;
    private FieldOfStudyEntity fieldsOfStudy;
    private List<ClassEntity> classes;
    private List<GradeEntity> grades;
    private boolean isActive;

    public StudentDto() {
    }

    public StudentDto(Long id, PersonalDataEntity personalData, String email, AddressEntity correspondenceAddress, int collegeId, String yearOfStudy, String studentsGroup, FieldOfStudyEntity fieldsOfStudy, List<ClassEntity> classes, List<GradeEntity> grades, boolean isActive) {
        this.id = id;
        this.personalData = personalData;
        this.email = email;
        this.correspondenceAddress = correspondenceAddress;
        this.collegeId = collegeId;
        this.yearOfStudy = yearOfStudy;
        this.studentsGroup = studentsGroup;
        this.fieldsOfStudy = fieldsOfStudy;
        this.classes = classes;
        this.grades = grades;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonalDataEntity getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalDataEntity personalData) {
        this.personalData = personalData;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressEntity getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public void setCorrespondenceAddress(AddressEntity correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getStudentsGroup() {
        return studentsGroup;
    }

    public void setStudentsGroup(String studentsGroup) {
        this.studentsGroup = studentsGroup;
    }

    public FieldOfStudyEntity getFieldsOfStudy() {
        return fieldsOfStudy;
    }

    public void setFieldsOfStudy(FieldOfStudyEntity fieldsOfStudy) {
        this.fieldsOfStudy = fieldsOfStudy;
    }

    public List<ClassEntity> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassEntity> classes) {
        this.classes = classes;
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
        return "StudentDto{" +
                "id=" + id +
                ", personalData=" + personalData +
                ", email='" + email + '\'' +
                ", correspondenceAddress=" + correspondenceAddress +
                ", collegeId=" + collegeId +
                ", yearOfStudy='" + yearOfStudy + '\'' +
                ", studentsGroup='" + studentsGroup + '\'' +
                ", fieldsOfStudy=" + fieldsOfStudy +
                ", classes=" + classes +
                ", grades=" + grades +
                ", isActive=" + isActive +
                '}';
    }
}
