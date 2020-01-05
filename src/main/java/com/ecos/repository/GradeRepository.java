package com.ecos.repository;

import com.ecos.model.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<GradeEntity, Long> {
}
