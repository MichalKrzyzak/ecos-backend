package com.ecos.dto;

import com.ecos.dto.simple.AssignmentSimpleDto;
import com.ecos.dto.simple.StudentSimpleDto;
import com.ecos.dto.simple.TeacherSimpleDto;

import java.util.List;

public class ClassDto {
    private Long id;
    private String className;
    private List<StudentSimpleDto> students;
    private List<TeacherSimpleDto> teachers;
    private FieldOfStudyDto fieldOfStudy;
    private List<AssignmentSimpleDto> assignments;

    public ClassDto() {
    }

    public ClassDto(Long id, String className, List<StudentSimpleDto> students, List<TeacherSimpleDto> teachers, FieldOfStudyDto fieldOfStudy, List<AssignmentSimpleDto> assignments) {
        this.id = id;
        this.className = className;
        this.students = students;
        this.teachers = teachers;
        this.fieldOfStudy = fieldOfStudy;
        this.assignments = assignments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<StudentSimpleDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentSimpleDto> students) {
        this.students = students;
    }

    public List<TeacherSimpleDto> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherSimpleDto> teachers) {
        this.teachers = teachers;
    }

    public FieldOfStudyDto getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudyDto fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public List<AssignmentSimpleDto> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignmentSimpleDto> assignments) {
        this.assignments = assignments;
    }

}
