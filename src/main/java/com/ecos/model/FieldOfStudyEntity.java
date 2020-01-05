package com.ecos.model;

import javax.persistence.*;

@Entity
@Table(name = "FieldsOfStudy")
public class FieldOfStudyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOS_ID")
    private long id;
    @Column(name = "FOS_NAME")
    private String fieldOfStudy;

    public FieldOfStudyEntity() {
    }

    public FieldOfStudyEntity(String fieldOfStudy) {
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
        return "FieldOfStudyEntity{" +
                "id=" + id +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                '}';
    }
}
