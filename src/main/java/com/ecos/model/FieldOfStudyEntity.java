package com.ecos.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fields_of_study")
public class FieldOfStudyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOS_ID", nullable = false)
    private Long id;
    @Column(name = "FOS_NAME")
    private String fieldOfStudy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fieldOfStudy", fetch = FetchType.LAZY)
    private List<StudentEntity> students;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fieldOfStudy")
    private List<ClassEntity> classes;

    public FieldOfStudyEntity() {
    }

    public FieldOfStudyEntity(Long id, String fieldOfStudy, List<StudentEntity> students, List<ClassEntity> classes) {
        this.id = id;
        this.fieldOfStudy = fieldOfStudy;
        this.students = students;
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    public List<ClassEntity> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassEntity> classes) {
        this.classes = classes;
    }

}
