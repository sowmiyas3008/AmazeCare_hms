package com.hexaware.hms.service;

import java.util.List;
import com.hexaware.hms.entity.Medicine;

public interface IMedicineService {
    Medicine addMedicine(Medicine medicine);
    List<Medicine> getAllMedicines();
}