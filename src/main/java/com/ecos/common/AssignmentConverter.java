package com.ecos.common;

import com.ecos.dto.AssignmentDto;
import com.ecos.model.AssignmentEntity;
import org.springframework.stereotype.Component;

@Component
public class AssignmentConverter implements BaseConverter<AssignmentEntity, AssignmentDto> {

    @Override
    public AssignmentDto convertToDto(AssignmentEntity entity) {
        AssignmentDto assignmentDto = new AssignmentDto();

        assignmentDto.setId(entity.getId());
        assignmentDto.setAssignment(entity.getAssignment());
        return assignmentDto;
    }

    @Override
    public AssignmentEntity convertToEntity(AssignmentDto dto) {
        AssignmentEntity assignmentEntity = new AssignmentEntity();

        assignmentEntity.setId(dto.getId());
        assignmentEntity.setAssignment(dto.getAssignment());
        return assignmentEntity;
    }
}
