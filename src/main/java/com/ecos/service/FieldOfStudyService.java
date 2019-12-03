package com.ecos.service;

import com.ecos.common.BaseConverter;
import com.ecos.dto.FieldOfStudyDto;
import com.ecos.model.FieldOfStudyEntity;
import com.ecos.repository.EcosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FieldOfStudyService implements BaseConverter<FieldOfStudyEntity, FieldOfStudyDto> {
    private final EcosRepository ecosRepository;

    public FieldOfStudyService(EcosRepository ecosRepository) {
        this.ecosRepository = ecosRepository;
    }

    public List<FieldOfStudyDto> getAllFieldsOfStudy() {
        List<FieldOfStudyEntity> fieldOfStudyEntities = new ArrayList<>(ecosRepository.findAll());

        return fieldOfStudyEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FieldOfStudyDto convertToDto(FieldOfStudyEntity fieldOfStudyEntity) {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setId(fieldOfStudyEntity.getId());
        fieldOfStudyDto.setFieldOfStudy(fieldOfStudyEntity.getFieldOfStudy());
        fieldOfStudyDto.setStudents(fieldOfStudyEntity.getStudents());
        return fieldOfStudyDto;
    }

    @Override
    public FieldOfStudyEntity convertToEntity(FieldOfStudyDto fieldOfStudyDto) {
        FieldOfStudyEntity fieldOfStudyEntity = new FieldOfStudyEntity();
        fieldOfStudyEntity.setId(fieldOfStudyDto.getId());
        fieldOfStudyEntity.setFieldOfStudy(fieldOfStudyDto.getFieldOfStudy());
        fieldOfStudyEntity.setStudents(fieldOfStudyDto.getStudents());
        return fieldOfStudyEntity;
    }
}
