package com.hexaware.hms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.ISpecializationDAO;
import com.hexaware.hms.dto.SpecializationRequestDTO;
import com.hexaware.hms.dto.SpecializationResponseDTO;
import com.hexaware.hms.entity.Specialization;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

    @Autowired
    private ISpecializationDAO specializationDAO;

    @Override
    public SpecializationResponseDTO addSpecialization(SpecializationRequestDTO dto) {

        Specialization s = new Specialization();
        s.setName(dto.getName());

        Specialization saved = specializationDAO.save(s);

        return mapToDTO(saved);
    }

    @Override
    public SpecializationResponseDTO getById(int id) {

        Specialization s = specializationDAO.findById(id).orElse(null);

        return mapToDTO(s);
    }

    @Override
    public List<SpecializationResponseDTO> getAll() {

        return specializationDAO.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SpecializationResponseDTO updateSpecialization(int id, SpecializationRequestDTO dto) {

        Optional<Specialization> existing = specializationDAO.findById(id);

        if (existing.isPresent()) {

            Specialization s = existing.get();
            s.setName(dto.getName());

            Specialization updated = specializationDAO.save(s);

            return mapToDTO(updated);
        }

        return null;
    }

    @Override
    public void deleteSpecialization(int id) {
        specializationDAO.deleteById(id);
    }

    @Override
    public int getDoctorCount(int specializationId) {
        return specializationDAO.countDoctorsBySpecialization(specializationId);
    }

    private SpecializationResponseDTO mapToDTO(Specialization s) {

        if (s == null) return null;

        SpecializationResponseDTO dto = new SpecializationResponseDTO();

        dto.setSpecializationId(s.getSpecializationId());
        dto.setName(s.getName());

        return dto;
    }
}