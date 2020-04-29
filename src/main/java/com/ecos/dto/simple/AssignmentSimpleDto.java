package com.ecos.dto.simple;

public class AssignmentSimpleDto {
    private Long id;
    private String assignment;

    public AssignmentSimpleDto() {
    }

    public AssignmentSimpleDto(Long id, String assignment) {
        this.id = id;
        this.assignment = assignment;
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
}
