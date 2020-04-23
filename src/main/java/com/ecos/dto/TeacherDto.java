package com.ecos.dto;

import com.ecos.model.AddressEntity;
import com.ecos.model.ClassEntity;
import com.ecos.model.PersonalDataEntity;

import java.util.List;

public class TeacherDto {
    private long id;
    private PersonalDataEntity personalData;
    private String email;
    private AddressEntity correspondenceAddress;
    private List<ClassEntity> classes;
    private boolean isActive;

    public TeacherDto() {
    }

    public TeacherDto(long id, PersonalDataEntity personalData, String email, AddressEntity correspondenceAddress, List<ClassEntity> classes, boolean isActive) {
        this.id = id;
        this.personalData = personalData;
        this.email = email;
        this.correspondenceAddress = correspondenceAddress;
        this.classes = classes;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<ClassEntity> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassEntity> classes) {
        this.classes = classes;
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
                ", personalData=" + personalData +
                ", email='" + email + '\'' +
                ", correspondenceAddress=" + correspondenceAddress +
                ", classes=" + classes +
                ", isActive=" + isActive +
                '}';
    }
}
