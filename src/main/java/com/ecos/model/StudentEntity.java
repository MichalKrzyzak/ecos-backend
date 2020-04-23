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
    @Column(nullable = false, unique = true, name = "COLLEGE_ID")
    private int collegeId;
    @Column
    private String yearOfStudy;
    @Column
    private String studentsGroup;
    @ManyToOne
    @JoinTable(name = "student_fos",
            joinColumns = {@JoinColumn(name = "student_entity_student_id")},
            inverseJoinColumns = {@JoinColumn(name = "field_of_study_fos_id")}
    )
    private FieldOfStudyEntity fieldOfStudy;
    @ManyToMany
    @JoinTable(name = "student_classes",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "class_id")}
    )
    private List<ClassEntity> classes;
    @OneToMany(mappedBy = "student")
    private List<GradeEntity> grades;
    private boolean isActive;

    public StudentEntity() {
    }

    public StudentEntity(long id, PersonalDataEntity personalData, String email, AddressEntity correspondenceAddress, int collegeId, String yearOfStudy, String studentsGroup, FieldOfStudyEntity fieldOfStudy, List<ClassEntity> classes, List<GradeEntity> grades, boolean isActive) {
        this.id = id;
        this.personalData = personalData;
        this.email = email;
        this.correspondenceAddress = correspondenceAddress;
        this.collegeId = collegeId;
        this.yearOfStudy = yearOfStudy;
        this.studentsGroup = studentsGroup;
        this.fieldOfStudy = fieldOfStudy;
        this.classes = classes;
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
        return fieldOfStudy;
    }

    public void setFieldsOfStudy(FieldOfStudyEntity fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
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
        return "StudentEntity{" +
                "id=" + id +
                ", personalData=" + personalData +
                ", email='" + email + '\'' +
                ", correspondenceAddress=" + correspondenceAddress +
                ", collegeId=" + collegeId +
                ", yearOfStudy='" + yearOfStudy + '\'' +
                ", studentsGroup='" + studentsGroup + '\'' +
                ", fieldOfStudy=" + fieldOfStudy +
                ", classes=" + classes +
                ", grades=" + grades +
                ", isActive=" + isActive +
                '}';
    }
}
