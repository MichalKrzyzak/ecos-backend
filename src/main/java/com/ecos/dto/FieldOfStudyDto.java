package com.ecos.dto;

public class FieldOfStudyDto {
    private long id;
    private String fieldOfStudy;

    public FieldOfStudyDto() {
    }

    public FieldOfStudyDto(long id, String fieldOfStudy) {
        this.id = id;
        this.fieldOfStudy = fieldOfStudy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    @Override
    public String toString() {
        return "FieldOfStudyDto{" +
                "id=" + id +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                '}';
    }
}
