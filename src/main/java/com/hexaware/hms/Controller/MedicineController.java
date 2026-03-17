package com.hexaware.hms.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.dto.MedicineRequestDTO;
import com.hexaware.hms.dto.MedicineResponseDTO;
import com.hexaware.hms.service.IMedicineService;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private IMedicineService medicineService;

    @PostMapping
    public MedicineResponseDTO addMedicine(@RequestBody MedicineRequestDTO medicine) {
        return medicineService.addMedicine(medicine);
    }

    @GetMapping
    public List<MedicineResponseDTO> getAllMedicines() {
        return medicineService.getAllMedicines();
    }
}