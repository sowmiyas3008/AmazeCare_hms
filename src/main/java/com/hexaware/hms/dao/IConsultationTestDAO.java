package com.hexaware.hms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.hms.entity.ConsultationTest;

public interface IConsultationTestDAO extends JpaRepository<ConsultationTest, Integer> {
	List<ConsultationTest> findByConsultationId(int consultationId);

}