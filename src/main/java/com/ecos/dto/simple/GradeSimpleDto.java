package com.ecos.dto.simple;

public class GradeSimpleDto {
    private Long id;
    private int grade;
    private String fieldOfStudy;
    private String assignment;

    public GradeSimpleDto() {
    }

    public GradeSimpleDto(Long id, int grade, String fieldOfStudy, String assignment) {
        this.id = id;
        this.grade = grade;
        this.fieldOfStudy = fieldOfStudy;
        this.assignment = assignment;
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

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }
}
