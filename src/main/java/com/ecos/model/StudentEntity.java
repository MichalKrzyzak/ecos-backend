package com.ecos.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID", nullable = false)
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
    @Column(nullable = false, name = "COLLEGE_ID")
    private int collegeId;
    @ManyToMany
    @JoinTable(name = "students_field_of_study",
            joinColumns = {@JoinColumn(name = "student_entity_student_id")},
            inverseJoinColumns = {@JoinColumn(name = "field_of_study_fos_id")}
    )
    private List<FieldOfStudyEntity> fieldsOfStudy;
    @OneToMany(mappedBy = "student")
    private List<GradeEntity> grades;
    private boolean isActive;

    public StudentEntity() {
    }

    public StudentEntity(PersonalDataEntity personalData, String email, AddressEntity correspondenceAddress, int collegeId, List<FieldOfStudyEntity> fieldsOfStudy, List<GradeEntity> grades, boolean isActive) {
        this.personalData = personalData;
        this.email = email;
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

    public List<FieldOfStudyEntity> getFieldsOfStudy() {
        return fieldsOfStudy;
    }

    public void setFieldsOfStudy(List<FieldOfStudyEntity> fieldsOfStudy) {
        this.fieldsOfStudy = fieldsOfStudy;
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
        return "StudentEntity{" +
                "id=" + id +
                ", personalData=" + personalData +
                ", email='" + email + '\'' +
                ", correspondenceAddress=" + correspondenceAddress +
                ", collegeId=" + collegeId +
                ", fieldsOfStudy=" + fieldsOfStudy +
                ", grades=" + grades +
                ", isActive=" + isActive +
                '}';
    }
}
