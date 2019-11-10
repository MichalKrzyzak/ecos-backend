package com.ecos.repository;

import com.ecos.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCollegeId(int collegeId);
    List<Student> findByPeselNumber(int peselNumber);
    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    List<Student> findByFieldOfStudy(String fieldOfStudy);

    void deleteByPeselNumber(int peselNumber);
    void deleteByCollegeId(int collegeId);
}
