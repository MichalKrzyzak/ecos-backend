package com.ecos.service.classes;

import com.ecos.dao.ClassRepository;
import com.ecos.dto.ClassDto;
import com.ecos.model.ClassEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClassServiceImpl implements ClassService<ClassDto, ClassEntity> {
    private final ClassRepository classRepository;
    private final ModelMapper modelMapper;

    public ClassServiceImpl(ClassRepository classRepository, ModelMapper modelMapper) {
        this.classRepository = classRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ClassDto> getAll() {
        List<ClassEntity> classEntities = new ArrayList<>(classRepository.findAll());

        return classEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClassDto create(@RequestBody ClassDto classDto) {
        ClassEntity classEntity = convertToEntity(classDto);
        return convertToDto(classRepository.save(classEntity));
    }

    @Override
    public ClassEntity convertToEntity(ClassDto dto) {
        return modelMapper.map(dto, ClassEntity.class);
    }

    @Override
    public ClassDto convertToDto(ClassEntity entity) {
        return modelMapper.map(entity, ClassDto.class);
    }
}
