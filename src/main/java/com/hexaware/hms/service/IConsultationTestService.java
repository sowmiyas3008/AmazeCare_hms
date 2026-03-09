package com.hexaware.hms.service;

import java.util.List;
import com.hexaware.hms.entity.ConsultationTest;

public interface IConsultationTestService {

    ConsultationTest addTestToConsultation(ConsultationTest ct);

    List<ConsultationTest> getTestsByConsultation(int consultationId);
}