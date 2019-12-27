package com.ecos.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FieldsOfStudy")
public class FieldOfStudyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fieldOfStudy;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "COLLEGE_ID")
    private List<StudentEntity> students;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID")
    private List<TeacherEntity> teachers;

    public FieldOfStudyEntity() {
    }

    public FieldOfStudyEntity(List<StudentEntity> students, List<TeacherEntity> teachers) {
        this.students = students;
        this.teachers = teachers;
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

    public List<TeacherEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherEntity> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "FieldOfStudyEntity{" +
                "id=" + id +
                ", fieldOfStudy=" + fieldOfStudy +
                ", students=" + students +
                ", teachers=" + teachers +
                '}';
    }
}
