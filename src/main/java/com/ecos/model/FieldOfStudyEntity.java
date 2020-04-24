package com.ecos.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fields_of_study")
public class FieldOfStudyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOS_ID", nullable = false)
    private long id;
    @Column(name = "FOS_NAME")
    private String fieldOfStudy;
    @OneToMany(mappedBy = "fieldOfStudy")
    private List<StudentEntity> students;
    @OneToMany(mappedBy = "fieldOfStudy")
    private List<ClassEntity> classes;

    public FieldOfStudyEntity() {
    }

    public FieldOfStudyEntity(long id, String fieldOfStudy, List<StudentEntity> students, List<ClassEntity> classes) {
        this.id = id;
        this.fieldOfStudy = fieldOfStudy;
        this.students = students;
        this.classes = classes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "FieldOfStudyEntity{" +
                "id=" + id +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", students=" + students +
                ", classes=" + classes +
                '}';
    }
}
