package com.ecos.repository;

import com.ecos.model.FieldOfStudyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldOfStudyRepository extends JpaRepository<FieldOfStudyEntity, Long> {
}
