package com.hexaware.hms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IConsultationTestDAO;
import com.hexaware.hms.dto.ConsultationTestRequestDTO;
import com.hexaware.hms.dto.ConsultationTestResponseDTO;
import com.hexaware.hms.entity.ConsultationTest;

@Service
public class ConsultationTestServiceImpl implements IConsultationTestService {

    @Autowired
    private IConsultationTestDAO consultationTestDAO;

    // ENTITY → DTO
    public ConsultationTestResponseDTO convertToDTO(ConsultationTest ct) {

        ConsultationTestResponseDTO dto = new ConsultationTestResponseDTO();

        dto.setId(ct.getId());
        dto.setConsultationId(ct.getConsultationId());
        dto.setTestId(ct.getTestId());

        return dto;
    }

    // DTO → ENTITY
    public ConsultationTest convertToEntity(ConsultationTestRequestDTO dto) {

        ConsultationTest ct = new ConsultationTest();

        ct.setConsultationId(dto.getConsultationId());
        ct.setTestId(dto.getTestId());

        return ct;
    }

    @Override
    public ConsultationTestResponseDTO addTestToConsultation(ConsultationTestRequestDTO dto) {

        ConsultationTest entity = convertToEntity(dto);

        ConsultationTest saved = consultationTestDAO.save(entity);

        return convertToDTO(saved);
    }

    @Override
    public List<ConsultationTestResponseDTO> getTestsByConsultation(int consultationId) {

        return consultationTestDAO.findByConsultationId(consultationId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}