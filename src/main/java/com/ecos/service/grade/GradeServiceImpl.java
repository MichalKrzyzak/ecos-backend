package com.ecos.service.grade;

import com.ecos.dao.GradeRepository;
import com.ecos.dto.GradeDto;
import com.ecos.model.GradeEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GradeServiceImpl implements GradeService<GradeDto, GradeEntity> {
    private final GradeRepository gradeRepository;
    private final ModelMapper modelMapper;

    public GradeServiceImpl(GradeRepository gradeRepository, ModelMapper modelMapper) {
        this.gradeRepository = gradeRepository;
        this.modelMapper = modelMapper;
    }

    public List<GradeDto> getAll() {
        List<GradeEntity> grades = new ArrayList<>(gradeRepository.findAll());

        return grades.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public GradeDto create(@RequestBody GradeDto gradeDto) {
        GradeEntity gradeEntity = convertToEntity(gradeDto);
        return convertToDto(gradeRepository.save(gradeEntity));
    }

    @Override
    public GradeEntity convertToEntity(GradeDto gradeDto) {
        return modelMapper.map(gradeDto, GradeEntity.class);
    }

    @Override
    public GradeDto convertToDto(GradeEntity gradeEntity) {
        return modelMapper.map(gradeEntity, GradeDto.class);
    }
}
