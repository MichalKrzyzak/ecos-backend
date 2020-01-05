package com.ecos.common;

import com.ecos.dto.GradeDto;
import com.ecos.model.GradeEntity;
import org.springframework.stereotype.Component;

@Component
public class GradeConverter implements BaseConverter<GradeEntity, GradeDto> {
    private FieldOfStudyConverter fieldOfStudyConverter;
    private AssignmentConverter assignmentConverter;
    private StudentConverter studentConverter;

    public GradeConverter(FieldOfStudyConverter fieldOfStudyConverter, AssignmentConverter assignmentConverter, StudentConverter studentConverter) {
        this.fieldOfStudyConverter = fieldOfStudyConverter;
        this.assignmentConverter = assignmentConverter;
        this.studentConverter = studentConverter;
    }

    @Override
    public GradeDto convertToDto(GradeEntity entity) {
        GradeDto gradeDto = new GradeDto();

        gradeDto.setId(entity.getId());
        gradeDto.setGrade(entity.getGrade());
        gradeDto.setFieldOfStudy(fieldOfStudyConverter.convertToDto(entity.getFieldOfStudy()));
        gradeDto.setAssignment(assignmentConverter.convertToDto(entity.getAssignment()));
        gradeDto.setStudent(studentConverter.convertToDto(entity.getStudent()));
        return gradeDto;
    }

    @Override
    public GradeEntity convertToEntity(GradeDto dto) {
        GradeEntity gradeEntity = new GradeEntity();

        gradeEntity.setId(dto.getId());
        gradeEntity.setGrade(dto.getGrade());
        gradeEntity.setFieldOfStudy(fieldOfStudyConverter.convertToEntity(dto.getFieldOfStudy()));
        gradeEntity.setAssignment(assignmentConverter.convertToEntity(dto.getAssignment()));
        gradeEntity.setStudent(studentConverter.convertToEntity(dto.getStudent()));
        return gradeEntity;
    }
}
