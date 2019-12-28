package com.ecos.common;

import com.ecos.dto.FieldOfStudyDto;
import com.ecos.model.FieldOfStudyEntity;
import org.springframework.stereotype.Component;

@Component
public class FieldOfStudyConverter implements BaseConverter<FieldOfStudyEntity, FieldOfStudyDto> {
    private StudentConverter studentConverter;
    private TeacherConverter teacherConverter;

    private FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
    private FieldOfStudyEntity fieldOfStudyEntity = new FieldOfStudyEntity();

    public FieldOfStudyConverter(StudentConverter studentConverter, TeacherConverter teacherConverter) {
        this.studentConverter = studentConverter;
        this.teacherConverter = teacherConverter;
    }

    @Override
    public FieldOfStudyDto convertToDto(FieldOfStudyEntity entity) {
        fieldOfStudyDto.setId(fieldOfStudyEntity.getId());
        fieldOfStudyDto.setFieldOfStudy(fieldOfStudyEntity.getFieldOfStudy());
        fieldOfStudyDto.setStudents(studentConverter.convertAllToDto(fieldOfStudyEntity.getStudents()));
        fieldOfStudyDto.setTeachers(teacherConverter.convertAllToDto(fieldOfStudyEntity.getTeachers()));
        return fieldOfStudyDto;
    }

    @Override
    public FieldOfStudyEntity convertToEntity(FieldOfStudyDto dto) {
        fieldOfStudyEntity.setId(fieldOfStudyDto.getId());
        fieldOfStudyEntity.setFieldOfStudy(fieldOfStudyDto.getFieldOfStudy());
        fieldOfStudyEntity.setStudents(studentConverter.convertAllToEntity(fieldOfStudyDto.getStudents()));
        fieldOfStudyEntity.setTeachers(teacherConverter.convertAllToEntity(fieldOfStudyDto.getTeachers()));
        return fieldOfStudyEntity;
    }
}
