package com.hexaware.hms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexaware.hms.dao.IMedicineDAO;
import com.hexaware.hms.entity.Medicine;
import com.hexaware.hms.service.IMedicineService;

@Service
public class MedicineServiceImpl implements IMedicineService {

    @Autowired
    private IMedicineDAO medicineDAO;

    public Medicine addMedicine(Medicine medicine) {
        return medicineDAO.save(medicine);
    }

    public List<Medicine> getAllMedicines() {
        return medicineDAO.findAll();
    }
}