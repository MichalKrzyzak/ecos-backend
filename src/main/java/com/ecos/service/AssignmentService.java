package com.ecos.service;

import com.ecos.common.AssignmentConverter;
import com.ecos.dto.AssignmentDto;
import com.ecos.model.AssignmentEntity;
import com.ecos.repository.AssignmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final AssignmentConverter assignmentConverter;

    public AssignmentService(AssignmentRepository assignmentRepository, AssignmentConverter assignmentConverter) {
        this.assignmentRepository = assignmentRepository;
        this.assignmentConverter = assignmentConverter;
    }

    public List<AssignmentDto> getAllAssignments() {
        List<AssignmentEntity> assignmentsEntity = new ArrayList<>(assignmentRepository.findAll());

        return assignmentsEntity.stream()
                .map(assignmentConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public AssignmentDto createAssignment(@RequestBody AssignmentDto assignmentDto) {
        AssignmentEntity assignment = assignmentConverter.convertToEntity(assignmentDto);
        return assignmentConverter.convertToDto(assignmentRepository.save(new AssignmentEntity(assignment.getAssignment())));
    }
}
