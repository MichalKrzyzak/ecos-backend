package com.ecos.dto;

public class AssignmentDto {
    private long id;
    private String assignment;

    public AssignmentDto() {
    }

    public AssignmentDto(long id, String assignment) {
        this.id = id;
        this.assignment = assignment;
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

    @Override
    public String toString() {
        return "AssignmentDto{" +
                "id=" + id +
                ", assignment='" + assignment + '\'' +
                '}';
    }
}
