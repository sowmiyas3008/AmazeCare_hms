package com.hexaware.hms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexaware.hms.dao.IConsultationTestDAO;
import com.hexaware.hms.entity.ConsultationTest;
import com.hexaware.hms.service.IConsultationTestService;

@Service
public class ConsultationTestServiceImpl implements IConsultationTestService {

    @Autowired
    private IConsultationTestDAO consultationTestDAO;

    public ConsultationTest addTestToConsultation(ConsultationTest ct) {
        return consultationTestDAO.save(ct);
    }

    public List<ConsultationTest> getTestsByConsultation(int consultationId) {
        return consultationTestDAO.findByConsultationId(consultationId);
    }
}