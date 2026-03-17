package com.hexaware.hms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IMedicineDAO;
import com.hexaware.hms.dto.MedicineRequestDTO;
import com.hexaware.hms.dto.MedicineResponseDTO;
import com.hexaware.hms.entity.Medicine;

@Service
public class MedicineServiceImpl implements IMedicineService {

    @Autowired
    private IMedicineDAO medicineDAO;

    @Override
    public MedicineResponseDTO addMedicine(MedicineRequestDTO dto) {

        // DTO → Entity
        Medicine medicine = new Medicine();
        medicine.setName(dto.getName());

        Medicine saved = medicineDAO.save(medicine);

        // Entity → ResponseDTO
        MedicineResponseDTO response = new MedicineResponseDTO();
        response.setMedicineId(saved.getMedicineId());
        response.setName(saved.getName());

        return response;
    }

    @Override
    public List<MedicineResponseDTO> getAllMedicines() {

        List<Medicine> medicines = medicineDAO.findAll();

        return medicines.stream().map(medicine -> {

            MedicineResponseDTO dto = new MedicineResponseDTO();
            dto.setMedicineId(medicine.getMedicineId());
            dto.setName(medicine.getName());

            return dto;

        }).collect(Collectors.toList());
    }
}