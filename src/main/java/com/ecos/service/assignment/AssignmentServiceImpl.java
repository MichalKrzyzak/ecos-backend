package com.ecos.service.assignment;

import com.ecos.dao.AssignmentRepository;
import com.ecos.dto.AssignmentDto;
import com.ecos.model.AssignmentEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AssignmentServiceImpl implements AssignmentService<AssignmentDto, AssignmentEntity> {
    private final AssignmentRepository assignmentRepository;
    private final ModelMapper modelMapper;

    public AssignmentServiceImpl(AssignmentRepository assignmentRepository, ModelMapper modelMapper) {
        this.assignmentRepository = assignmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AssignmentDto> getAll() {
        List<AssignmentEntity> assignmentsEntity = new ArrayList<>(assignmentRepository.findAll());

        return assignmentsEntity.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AssignmentDto create(@RequestBody AssignmentDto assignmentDto) {
        AssignmentEntity assignment = convertToEntity(assignmentDto);
        return convertToDto(assignmentRepository.save(assignment));
    }

    @Override
    public AssignmentEntity convertToEntity(AssignmentDto assignmentDto) {
        return modelMapper.map(assignmentDto, AssignmentEntity.class);
    }

    @Override
    public AssignmentDto convertToDto(AssignmentEntity assignmentEntity) {
        return modelMapper.map(assignmentEntity, AssignmentDto.class);
    }
}
