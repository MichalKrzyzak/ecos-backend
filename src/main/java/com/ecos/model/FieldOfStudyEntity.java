package com.ecos.model;

import com.ecos.model.enums.FieldOfStudyEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Fields Of Study")
public class FieldOfStudyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private FieldOfStudyEnum fieldOfStudyEnum;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "COLLEGE_ID")
    private Set<StudentEntity> students;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID")
    private Set<TeacherEntity> teachers;

    public FieldOfStudyEntity() {
    }

    public FieldOfStudyEntity(FieldOfStudyEnum fieldOfStudy, Set<StudentEntity> students) {
        this.fieldOfStudyEnum = fieldOfStudy;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FieldOfStudyEnum getFieldOfStudy() {
        return fieldOfStudyEnum;
    }

    public void setFieldOfStudy(FieldOfStudyEnum fieldOfStudy) {
        this.fieldOfStudyEnum = fieldOfStudy;
    }

    public Set<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentEntity> students) {
        this.students = students;
    }

    public Set<TeacherEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TeacherEntity> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "FieldOfStudyEntity{" +
                "id=" + id +
                ", fieldOfStudy=" + fieldOfStudyEnum +
                ", students=" + students +
                ", teachers=" + teachers +
                '}';
    }
}
