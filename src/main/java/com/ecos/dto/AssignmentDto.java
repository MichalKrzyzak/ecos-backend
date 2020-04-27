package com.ecos.dto;

import java.util.Date;

public class AssignmentDto {
    private Long id;
    private String assignment;
    private Date assessmentDate;
    private ClassDto classDto;

    public AssignmentDto() {
    }

    public AssignmentDto(Long id, String assignment, Date assessmentDate, ClassDto classDto) {
        this.id = id;
        this.assignment = assignment;
        this.assessmentDate = assessmentDate;
        this.classDto = classDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public ClassDto getClassDto() {
        return classDto;
    }

    public void setClassDto(ClassDto classDto) {
        this.classDto = classDto;
    }

    @Override
    public String toString() {
        return "AssignmentDto{" +
                "id=" + id +
                ", assignment='" + assignment + '\'' +
                ", assessmentDate=" + assessmentDate +
                ", classDto=" + classDto +
                '}';
    }
}
