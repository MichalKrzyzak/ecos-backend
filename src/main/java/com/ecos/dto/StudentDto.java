package com.ecos.dto;

import com.ecos.dto.simple.ClassSimpleDto;
import com.ecos.dto.simple.FosSimpleDto;
import com.ecos.dto.simple.GradeSimpleDto;

import java.util.List;

public class StudentDto {
    private Long id;
    private PersonalDataDto personalData;
    private String email;
    private AddressDto correspondenceAddress;
    private int collegeId;
    private String yearOfStudy;
    private String studentsGroup;
    private FosSimpleDto fieldsOfStudy;
    private List<ClassSimpleDto> classes;
    private List<GradeSimpleDto> grades;
    private boolean isActive;

    public StudentDto() {
    }

    public StudentDto(Long id, PersonalDataDto personalData, String email, AddressDto correspondenceAddress, int collegeId, String yearOfStudy, String studentsGroup, FosSimpleDto fieldsOfStudy, List<ClassSimpleDto> classes, List<GradeSimpleDto> grades, boolean isActive) {
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

    public FosSimpleDto getFieldsOfStudy() {
        return fieldsOfStudy;
    }

    public void setFieldsOfStudy(FosSimpleDto fieldsOfStudy) {
        this.fieldsOfStudy = fieldsOfStudy;
    }

    public List<ClassSimpleDto> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassSimpleDto> classes) {
        this.classes = classes;
    }

    public List<GradeSimpleDto> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeSimpleDto> grades) {
        this.grades = grades;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
