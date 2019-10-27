package com.ecos.repository;

import com.ecos.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByCollegeId(int collegeId);
    Optional<Student> findByCollegeIdOptional(int collegeId);
    List<Student> findByPeselNumber(int peselNumber);
    Optional<Student> findByPeselNumberOptional(int peselNumber);
    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    List<Student> findByFieldOfStudy(String fieldOfStudy);
    Optional<Student> findByFieldOfStudyOptional(String fieldOfStudy);

    void deleteByPeselNumber(int peselNumber);
    void deleteByCollegeId(int collegeId);
}
