package com.hexaware.hms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IMedicalTestDAO;
import com.hexaware.hms.dto.MedicalTestRequestDTO;
import com.hexaware.hms.dto.MedicalTestResponseDTO;
import com.hexaware.hms.entity.MedicalTest;

@Service
public class MedicalTestServiceImpl implements IMedicalTestService {

    @Autowired
    private IMedicalTestDAO testDAO;

    @Override
    public MedicalTestResponseDTO addTest(MedicalTestRequestDTO dto) {

        // DTO → Entity
        MedicalTest test = new MedicalTest();
        test.setTestName(dto.getTestName());

        MedicalTest saved = testDAO.save(test);

        // Entity → DTO
        MedicalTestResponseDTO response = new MedicalTestResponseDTO();
        response.setTestId(saved.getTestId());
        response.setTestName(saved.getTestName());

        return response;
    }

    @Override
    public List<MedicalTestResponseDTO> getAllTests() {

        List<MedicalTest> tests = testDAO.findAll();

        return tests.stream().map(test -> {
            MedicalTestResponseDTO dto = new MedicalTestResponseDTO();
            dto.setTestId(test.getTestId());
            dto.setTestName(test.getTestName());
            return dto;
        }).collect(Collectors.toList());
    }
}