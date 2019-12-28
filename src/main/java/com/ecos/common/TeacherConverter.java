package com.ecos.common;

import com.ecos.dto.TeacherDto;
import com.ecos.model.TeacherEntity;
import org.springframework.stereotype.Component;

@Component
public class TeacherConverter implements BaseConverter<TeacherEntity, TeacherDto> {
    private TeacherEntity teacherEntity = new TeacherEntity();
    private TeacherDto teacherDto = new TeacherDto();

    @Override
    public TeacherDto convertToDto(TeacherEntity entity) {
        teacherDto.setId(teacherEntity.getId());
        teacherDto.setFirstName(teacherEntity.getFirstName());
        teacherDto.setLastName(teacherEntity.getLastName());
        teacherDto.setPeselNumber(teacherEntity.getPeselNumber());
        teacherDto.setTeacherRole(teacherEntity.getTeacherRole());
        teacherDto.setActive(teacherEntity.isActive());
        return teacherDto;
    }

    @Override
    public TeacherEntity convertToEntity(TeacherDto dto) {
        teacherEntity.setId(teacherDto.getId());
        teacherEntity.setFirstName(teacherDto.getFirstName());
        teacherEntity.setLastName(teacherDto.getLastName());
        teacherEntity.setPeselNumber(teacherDto.getPeselNumber());
        teacherEntity.setTeacherRole(teacherDto.getTeacherRole());
        teacherEntity.setActive(teacherDto.isActive());
        return teacherEntity;
    }
}
