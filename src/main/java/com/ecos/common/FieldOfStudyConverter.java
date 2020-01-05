package com.ecos.common;

import com.ecos.dto.FieldOfStudyDto;
import com.ecos.model.FieldOfStudyEntity;
import org.springframework.stereotype.Component;

@Component
public class FieldOfStudyConverter implements BaseConverter<FieldOfStudyEntity, FieldOfStudyDto> {

    @Override
    public FieldOfStudyDto convertToDto(FieldOfStudyEntity entity) {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();

        fieldOfStudyDto.setId(entity.getId());
        fieldOfStudyDto.setFieldOfStudy(entity.getFieldOfStudy());
        return fieldOfStudyDto;
    }

    @Override
    public FieldOfStudyEntity convertToEntity(FieldOfStudyDto dto) {
        FieldOfStudyEntity fieldOfStudyEntity = new FieldOfStudyEntity();

        fieldOfStudyEntity.setId(dto.getId());
        fieldOfStudyEntity.setFieldOfStudy(dto.getFieldOfStudy());
        return fieldOfStudyEntity;
    }
}
