package com.ecos.model;

import javax.persistence.*;

@Entity
@Table(name = "Teachers")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEACHER_ID", nullable = false)
    private long id;
    @Embedded
    private PersonalDataEntity personalData;
    @Column(unique = true)
    private String email;
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "addressLine1", column = @Column(name = "correspondence_street")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "correspondence_house_number")),
            @AttributeOverride(name = "addressLine3", column = @Column(name = "correspondence_apartment_number"))
    })
    private AddressEntity correspondenceAddress;
    @ManyToOne
    @JoinColumn(name = "FOS_ID")
    private FieldOfStudyEntity fieldOfStudy;
    @Column(nullable = false)
    private boolean isActive;

    public TeacherEntity() {
    }

    public TeacherEntity(PersonalDataEntity personalData, String email, AddressEntity correspondenceAddress, FieldOfStudyEntity fieldOfStudy, boolean isActive) {
        this.personalData = personalData;
        this.email = email;
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

    public FieldOfStudyEntity getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudyEntity fieldOfStudy) {
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
        return "TeacherEntity{" +
                "id=" + id +
                ", personalData=" + personalData +
                ", email='" + email + '\'' +
                ", correspondenceAddress=" + correspondenceAddress +
                ", fieldOfStudy=" + fieldOfStudy +
                ", isActive=" + isActive +
                '}';
    }
}
