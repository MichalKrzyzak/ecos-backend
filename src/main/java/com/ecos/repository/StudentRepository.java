package com.ecos.repository;

import com.ecos.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCollegeId(int collegeId);
    List<Student> findByPeselNumber(long peselNumber);
    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    List<Student> findByFieldOfStudy(String fieldOfStudy);

    void deleteByPeselNumber(long peselNumber);
    void deleteByCollegeId(int collegeId);
}
