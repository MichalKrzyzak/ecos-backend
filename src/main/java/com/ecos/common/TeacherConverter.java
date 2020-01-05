package com.ecos.common;

import com.ecos.dto.TeacherDto;
import com.ecos.model.TeacherEntity;
import org.springframework.stereotype.Component;

@Component
public class TeacherConverter implements BaseConverter<TeacherEntity, TeacherDto> {

    @Override
    public TeacherDto convertToDto(TeacherEntity entity) {
        TeacherDto teacherDto = new TeacherDto();

        teacherDto.setId(entity.getId());
        teacherDto.setFirstName(entity.getFirstName());
        teacherDto.setLastName(entity.getLastName());
        teacherDto.setPeselNumber(entity.getPeselNumber());
        teacherDto.setActive(entity.isActive());
        return teacherDto;
    }

    @Override
    public TeacherEntity convertToEntity(TeacherDto dto) {
        TeacherEntity teacherEntity = new TeacherEntity();

        teacherEntity.setId(dto.getId());
        teacherEntity.setFirstName(dto.getFirstName());
        teacherEntity.setLastName(dto.getLastName());
        teacherEntity.setPeselNumber(dto.getPeselNumber());
        teacherEntity.setActive(dto.isActive());
        return teacherEntity;
    }
}
