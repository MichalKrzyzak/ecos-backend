package com.ecos.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Classes")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASS_ID", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String className;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "classes")
    private List<StudentEntity> students;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "classes")
    private List<TeacherEntity> teachers;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FOS_ID")
    private FieldOfStudyEntity fieldOfStudy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classEntity")
    private List<AssignmentEntity> assignments;

    public ClassEntity() {
    }

    public ClassEntity(Long id, String className, List<StudentEntity> students, List<TeacherEntity> teachers, FieldOfStudyEntity fieldOfStudy, List<AssignmentEntity> assignments) {
        this.id = id;
        this.className = className;
        this.students = students;
        this.teachers = teachers;
        this.fieldOfStudy = fieldOfStudy;
        this.assignments = assignments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public FieldOfStudyEntity getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudyEntity fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public List<AssignmentEntity> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignmentEntity> assignments) {
        this.assignments = assignments;
    }

}
