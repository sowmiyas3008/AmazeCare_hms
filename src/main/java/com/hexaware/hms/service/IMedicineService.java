package com.hexaware.hms.service;

import java.util.List;

import com.hexaware.hms.dto.MedicineRequestDTO;
import com.hexaware.hms.dto.MedicineResponseDTO;

public interface IMedicineService {

    MedicineResponseDTO addMedicine(MedicineRequestDTO dto);

    List<MedicineResponseDTO> getAllMedicines();
}