package com.ecos.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Classes")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASS_ID", nullable = false)
    private long id;
    @Column(nullable = false)
    private String className;
    @ManyToMany(mappedBy = "classes")
    private List<StudentEntity> students;
    @ManyToMany(mappedBy = "classes")
    private List<TeacherEntity> teachers;

    public ClassEntity() {
    }

    public ClassEntity(long id, String className) {
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
        return "ClassEntity{" +
                "id=" + id +
                ", className='" + className + '\'' +
                '}';
    }
}
