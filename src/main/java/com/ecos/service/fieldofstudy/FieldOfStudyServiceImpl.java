package com.ecos.service.fieldofstudy;

import com.ecos.dao.FieldOfStudyRepository;
import com.ecos.dto.FieldOfStudyDto;
import com.ecos.model.FieldOfStudyEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FieldOfStudyServiceImpl implements FieldOfStudyService<FieldOfStudyDto, FieldOfStudyEntity> {
    private final FieldOfStudyRepository fieldOfStudyRepository;
    private final ModelMapper modelMapper;

    public FieldOfStudyServiceImpl(FieldOfStudyRepository fieldOfStudyRepository, ModelMapper modelMapper) {
        this.fieldOfStudyRepository = fieldOfStudyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FieldOfStudyDto> getAll() {
        List<FieldOfStudyEntity> fieldOfStudyEntities = new ArrayList<>(fieldOfStudyRepository.findAll());

        return fieldOfStudyEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FieldOfStudyDto create(@RequestBody FieldOfStudyDto fieldOfStudyDto) {
        FieldOfStudyEntity fieldOfStudy = convertToEntity(fieldOfStudyDto);
        return convertToDto(fieldOfStudyRepository.save(fieldOfStudy));
    }

    @Override
    public FieldOfStudyEntity convertToEntity(FieldOfStudyDto fieldOfStudyDto) {
        return modelMapper.map(fieldOfStudyDto, FieldOfStudyEntity.class);
    }

    @Override
    public FieldOfStudyDto convertToDto(FieldOfStudyEntity fieldOfStudyEntity) {
        return modelMapper.map(fieldOfStudyEntity, FieldOfStudyDto.class);
    }
}
