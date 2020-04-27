package com.ecos.dto;

import java.util.List;

public class FieldOfStudyDto {
    private Long id;
    private String fieldOfStudy;
    private List<StudentDto> students;
    private List<ClassDto> classes;

    public FieldOfStudyDto() {
    }

    public FieldOfStudyDto(Long id, String fieldOfStudy, List<StudentDto> students, List<ClassDto> classes) {
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

    public List<ClassDto> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassDto> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "FieldOfStudyDto{" +
                "id=" + id +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", students=" + students +
                ", classes=" + classes +
                '}';
    }
}
