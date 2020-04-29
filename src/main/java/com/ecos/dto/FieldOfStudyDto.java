package com.ecos.dto;

import com.ecos.dto.simple.ClassSimpleDto;

import java.util.List;

public class FieldOfStudyDto {
    private Long id;
    private String fieldOfStudy;
    private List<StudentDto> students;
    private List<ClassSimpleDto> classes;

    public FieldOfStudyDto() {
    }

    public FieldOfStudyDto(Long id, String fieldOfStudy, List<StudentDto> students, List<ClassSimpleDto> classes) {
        this.id = id;
        this.fieldOfStudy = fieldOfStudy;
        this.students = students;
        this.classes = classes;
    }

    public Long getId() {
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

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public List<ClassSimpleDto> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassSimpleDto> classes) {
        this.classes = classes;
    }

}
