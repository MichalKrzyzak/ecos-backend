package com.ecos.dto;

import java.util.List;

public class ClassDto {
    private Long id;
    private String className;
    private List<StudentDto> students;
    private List<TeacherDto> teachers;
    private FieldOfStudyDto fieldOfStudy;
    private List<AssignmentDto> assignments;

    public ClassDto() {
    }

    public ClassDto(Long id, String className, List<StudentDto> students, List<TeacherDto> teachers, FieldOfStudyDto fieldOfStudy, List<AssignmentDto> assignments) {
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

    public FieldOfStudyDto getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudyDto fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public List<AssignmentDto> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignmentDto> assignments) {
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "ClassDto{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", students=" + students +
                ", teachers=" + teachers +
                ", fieldOfStudy=" + fieldOfStudy +
                ", assignments=" + assignments +
                '}';
    }
}
