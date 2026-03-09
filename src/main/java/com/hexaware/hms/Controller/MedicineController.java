package com.hexaware.hms.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.entity.Medicine;
import com.hexaware.hms.service.IMedicineService;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private IMedicineService medicineService;

    @PostMapping
    public Medicine addMedicine(@RequestBody Medicine medicine) {
        return medicineService.addMedicine(medicine);
    }

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineService.getAllMedicines();
    }
}
