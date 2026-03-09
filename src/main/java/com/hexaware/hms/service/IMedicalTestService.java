package com.hexaware.hms.service;

import java.util.List;
import com.hexaware.hms.entity.MedicalTest;

public interface IMedicalTestService {
    MedicalTest addTest(MedicalTest test);
    List<MedicalTest> getAllTests();
}