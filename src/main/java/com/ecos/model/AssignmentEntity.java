package com.ecos.model;

import javax.persistence.*;

@Entity
@Table(name = "Assignments")
public class AssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    private long id;
    @Column(name = "assignment_name")
    private String assignment;

    public AssignmentEntity() {
    }

    public AssignmentEntity(String assignment) {
        this.assignment = assignment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    @Override
    public String toString() {
        return "AssignmentEntity{" +
                "id=" + id +
                ", assignment='" + assignment + '\'' +
                '}';
    }
}
