package com.ecos.dto;

public class TeacherDto {
    private long id;
    private PersonalDataDto personalData;
    private String email;
    private AddressDto registeredAddress;
    private AddressDto correspondenceAddress;
    private FieldOfStudyDto fieldOfStudy;
    private boolean isActive;

    public TeacherDto(long id, PersonalDataDto personalData, String email, AddressDto registeredAddress, AddressDto correspondenceAddress, FieldOfStudyDto fieldOfStudy, boolean isActive) {
        this.id = id;
        this.personalData = personalData;
        this.email = email;
        this.registeredAddress = registeredAddress;
        this.correspondenceAddress = correspondenceAddress;
        this.fieldOfStudy = fieldOfStudy;
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
                ", personalData=" + personalData +
                ", email='" + email + '\'' +
                ", registeredAddress=" + registeredAddress +
                ", correspondenceAddress=" + correspondenceAddress +
                ", fieldOfStudy=" + fieldOfStudy +
                ", isActive=" + isActive +
                '}';
    }
}
