package com.ecos.model;

import javax.persistence.*;

@Entity
@Table(name = "Grades")
public class GradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id", nullable = false)
    private Long id;
    @Column(name = "grade")
    private int grade;
    @OneToOne
    private FieldOfStudyEntity fieldOfStudy;
    @OneToOne
    private AssignmentEntity assignment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STUDENT_ID")
    private StudentEntity student;

    public GradeEntity() {
    }

    public GradeEntity(int grade, FieldOfStudyEntity fieldOfStudy, AssignmentEntity assignment, StudentEntity student) {
        this.grade = grade;
        this.fieldOfStudy = fieldOfStudy;
        this.assignment = assignment;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public FieldOfStudyEntity getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudyEntity fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public AssignmentEntity getAssignment() {
        return assignment;
    }

    public void setAssignment(AssignmentEntity assignment) {
        this.assignment = assignment;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

}
