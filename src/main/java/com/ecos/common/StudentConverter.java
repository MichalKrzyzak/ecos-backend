package com.ecos.common;

import com.ecos.dto.StudentDto;
import com.ecos.model.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter implements BaseConverter<StudentEntity, StudentDto> {

    private StudentDto studentDto = new StudentDto();
    private StudentEntity studentEntity = new StudentEntity();

    @Override
    public StudentDto convertToDto(StudentEntity entity) {
        studentDto.setId(studentEntity.getId());
        studentDto.setFirstName(studentEntity.getFirstName());
        studentDto.setLastName(studentEntity.getLastName());
        studentDto.setPeselNumber(studentEntity.getPeselNumber());
        studentDto.setCollegeId(studentEntity.getCollegeId());
        studentDto.setActive(studentEntity.isActive());
        return studentDto;
    }

    @Override
    public StudentEntity convertToEntity(StudentDto dto) {
        studentEntity.setId(studentDto.getId());
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setPeselNumber(studentDto.getPeselNumber());
        studentEntity.setCollegeId(studentDto.getCollegeId());
        studentEntity.setActive(studentDto.isActive());
        return studentEntity;
    }
}
