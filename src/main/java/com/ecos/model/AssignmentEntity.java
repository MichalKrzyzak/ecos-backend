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
    @JoinColumn(name = "FOS_ID")
    private FieldOfStudyEntity fieldOfStudy;

    public AssignmentEntity() {
    }

    public AssignmentEntity(String assignment, FieldOfStudyEntity fieldOfStudy) {
        this.assignment = assignment;
        this.fieldOfStudy = fieldOfStudy;
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

    public FieldOfStudyEntity getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudyEntity fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    @Override
    public String toString() {
        return "AssignmentEntity{" +
                "id=" + id +
                ", assignment='" + assignment + '\'' +
                ", assessmentDate=" + assessmentDate +
                ", fieldOfStudy=" + fieldOfStudy +
                '}';
    }
}
