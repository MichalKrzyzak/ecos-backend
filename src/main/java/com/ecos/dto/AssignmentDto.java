package com.ecos.dto;

import com.ecos.dto.simple.ClassSimpleDto;

import java.util.Date;

public class AssignmentDto {
    private Long id;
    private String assignment;
    private Date assessmentDate;
    private ClassSimpleDto classDto;

    public AssignmentDto() {
    }

    public AssignmentDto(Long id, String assignment, Date assessmentDate, ClassSimpleDto classDto) {
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

    public ClassSimpleDto getClassDto() {
        return classDto;
    }

    public void setClassDto(ClassSimpleDto classDto) {
        this.classDto = classDto;
    }

}
