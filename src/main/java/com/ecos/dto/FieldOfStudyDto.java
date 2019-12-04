package com.ecos.dto;

import com.ecos.model.enums.FieldOfStudyEnum;

import java.util.Set;

public class FieldOfStudyDto {
    private long id;
    private FieldOfStudyEnum fieldOfStudyEnum;
    private Set<StudentDto> students;
    private Set<TeacherDto> teachers;

    public FieldOfStudyDto() {
    }

    public FieldOfStudyDto(long id, FieldOfStudyEnum fieldOfStudy, Set<StudentDto> students) {
        this.id = id;
        this.fieldOfStudyEnum = fieldOfStudy;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FieldOfStudyEnum getFieldOfStudy() {
        return fieldOfStudyEnum;
    }

    public void setFieldOfStudy(FieldOfStudyEnum fieldOfStudy) {
        this.fieldOfStudyEnum = fieldOfStudy;
    }

    public Set<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentDto> students) {
        this.students = students;
    }

    public Set<TeacherDto> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TeacherDto> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "FieldOfStudyDto{" +
                "id=" + id +
                ", fieldOfStudy=" + fieldOfStudyEnum +
                ", students=" + students +
                '}';
    }
}
