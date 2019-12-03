package com.ecos.repository;

import com.ecos.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcosRepository extends JpaRepository<StudentEntity, Long> {
}
