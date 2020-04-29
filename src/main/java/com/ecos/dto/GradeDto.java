package com.ecos.dto;

public class GradeDto {
    private Long id;
    private int grade;
    private FieldOfStudyDto fieldOfStudy;
    private AssignmentDto assignment;
    private StudentDto student;

    public GradeDto() {
    }

    public GradeDto(Long id, int grade, FieldOfStudyDto fieldOfStudy, AssignmentDto assignment, StudentDto student) {
        this.id = id;
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

    public FieldOfStudyDto getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudyDto fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public AssignmentDto getAssignment() {
        return assignment;
    }

    public void setAssignment(AssignmentDto assignment) {
        this.assignment = assignment;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }

}
