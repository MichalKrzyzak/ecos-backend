package com.ecos.service;

import com.ecos.common.GradeConverter;
import com.ecos.dto.GradeDto;
import com.ecos.model.GradeEntity;
import com.ecos.repository.GradeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GradeService {
    private final GradeRepository gradeRepository;
    private final GradeConverter gradeConverter;

    public GradeService(GradeRepository gradeRepository, GradeConverter gradeConverter) {
        this.gradeRepository = gradeRepository;
        this.gradeConverter = gradeConverter;
    }

    public List<GradeDto> getAllGrades() {
        List<GradeEntity> grades = new ArrayList<>(gradeRepository.findAll());

        return grades.stream()
                .map(gradeConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public GradeDto createGrade(@RequestBody GradeDto gradeDto) {
        GradeEntity gradeEntity = gradeConverter.convertToEntity(gradeDto);

        return gradeConverter.convertToDto(gradeRepository.save(new GradeEntity(gradeEntity.getGrade(), gradeEntity.getFieldOfStudy(), gradeEntity.getAssignment(), gradeEntity.getStudent())));
    }
}
