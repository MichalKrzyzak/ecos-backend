package com.ecos.dto;

import java.util.List;

public class FieldOfStudyDto {
    private long id;
    private String fieldOfStudy;
    private List<StudentDto> students;
    private List<TeacherDto> teachers;

    public FieldOfStudyDto() {
    }

    public FieldOfStudyDto(long id, String fieldOfStudy, List<StudentDto> students, List<TeacherDto> teachers) {
        this.id = id;
        this.fieldOfStudy = fieldOfStudy;
        this.students = students;
        this.teachers = teachers;
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

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public List<TeacherDto> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherDto> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "FieldOfStudyDto{" +
                "id=" + id +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", students=" + students +
                ", teachers=" + teachers +
                '}';
    }
}
