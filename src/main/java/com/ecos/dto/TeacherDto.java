package com.ecos.dto;

import com.ecos.dto.simple.ClassSimpleDto;

import java.util.List;

public class TeacherDto {
    private Long id;
    private PersonalDataDto personalData;
    private String email;
    private AddressDto correspondenceAddress;
    private List<ClassSimpleDto> classes;
    private boolean isActive;

    public TeacherDto() {
    }

    public TeacherDto(Long id, PersonalDataDto personalData, String email, AddressDto correspondenceAddress, List<ClassSimpleDto> classes, boolean isActive) {
        this.id = id;
        this.personalData = personalData;
        this.email = email;
        this.correspondenceAddress = correspondenceAddress;
        this.classes = classes;
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

    public List<ClassSimpleDto> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassSimpleDto> classes) {
        this.classes = classes;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
