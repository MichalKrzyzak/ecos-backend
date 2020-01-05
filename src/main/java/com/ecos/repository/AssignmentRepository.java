package com.ecos.repository;

import com.ecos.model.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long> {
}
