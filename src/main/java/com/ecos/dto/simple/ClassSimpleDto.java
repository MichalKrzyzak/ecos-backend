package com.ecos.dto.simple;

public class ClassSimpleDto {
    private Long id;
    private String className;
    private TeacherSimpleDto teacher;

    public ClassSimpleDto() {
    }

    public ClassSimpleDto(Long id, String className, TeacherSimpleDto teacher) {
        this.id = id;
        this.className = className;
        this.teacher = teacher;
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

    public TeacherSimpleDto getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherSimpleDto teacher) {
        this.teacher = teacher;
    }
}
