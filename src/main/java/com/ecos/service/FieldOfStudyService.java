package com.ecos.service;

import com.ecos.common.FieldOfStudyConverter;
import com.ecos.dto.FieldOfStudyDto;
import com.ecos.dto.StudentDto;
import com.ecos.dto.TeacherDto;
import com.ecos.model.FieldOfStudyEntity;
import com.ecos.repository.FieldOfStudyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FieldOfStudyService {
    private final FieldOfStudyRepository fieldOfStudyRepository;
    private final FieldOfStudyConverter fieldOfStudyConverter;

    public FieldOfStudyService(FieldOfStudyRepository fieldOfStudyRepository, FieldOfStudyConverter fieldOfStudyConverter) {
        this.fieldOfStudyRepository = fieldOfStudyRepository;
        this.fieldOfStudyConverter = fieldOfStudyConverter;
    }

    public List<FieldOfStudyDto> getAllFieldsOfStudy() {
        List<FieldOfStudyEntity> fieldOfStudyEntities = new ArrayList<>(fieldOfStudyRepository.findAll());

        return fieldOfStudyEntities.stream()
                .map(fieldOfStudyConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public FieldOfStudyDto createFieldOfStudy(@RequestBody FieldOfStudyDto fieldOfStudyDto) {
        FieldOfStudyEntity fieldOfStudy = fieldOfStudyConverter.convertToEntity(fieldOfStudyDto);
        return fieldOfStudyConverter.convertToDto(fieldOfStudyRepository.save(new FieldOfStudyEntity(fieldOfStudy.getFieldOfStudy())));
    }
}
