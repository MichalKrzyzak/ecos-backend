package com.ecos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Assignments")
public class AssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id", nullable = false)
    private long id;
    @Column(name = "assignment_name")
    private String assignment;
    @Column(name = "assignment_date")
    private Date assessmentDate;
    @ManyToOne
    @JoinColumn(name = "CLASS_ID")
    private ClassEntity classEntity;

    public AssignmentEntity() {
    }

    public AssignmentEntity(long id, String assignment, Date assessmentDate, ClassEntity classEntity) {
        this.id = id;
        this.assignment = assignment;
        this.assessmentDate = assessmentDate;
        this.classEntity = classEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public Date getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(Date assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    @Override
    public String toString() {
        return "AssignmentEntity{" +
                "id=" + id +
                ", assignment='" + assignment + '\'' +
                ", assessmentDate=" + assessmentDate +
                ", classEntity=" + classEntity +
                '}';
    }
}
