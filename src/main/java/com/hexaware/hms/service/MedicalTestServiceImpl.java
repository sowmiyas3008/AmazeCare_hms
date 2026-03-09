package com.hexaware.hms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexaware.hms.dao.IMedicalTestDAO;
import com.hexaware.hms.entity.MedicalTest;
import com.hexaware.hms.service.IMedicalTestService;

@Service
public class MedicalTestServiceImpl implements IMedicalTestService {

    @Autowired
    private IMedicalTestDAO testDAO;

    public MedicalTest addTest(MedicalTest test) {
        return testDAO.save(test);
    }

    public List<MedicalTest> getAllTests() {
        return testDAO.findAll();
    }
}