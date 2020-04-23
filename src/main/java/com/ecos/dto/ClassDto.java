package com.ecos.dto;

public class ClassDto {
    private long id;
    private String className;

    public ClassDto() {
    }

    public ClassDto(long id, String className) {
        this.id = id;
        this.className = className;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "ClassDto{" +
                "id=" + id +
                ", className='" + className + '\'' +
                '}';
    }
}
