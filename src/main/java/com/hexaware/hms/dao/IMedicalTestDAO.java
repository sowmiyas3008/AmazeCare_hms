package com.hexaware.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.hms.entity.MedicalTest;

public interface IMedicalTestDAO extends JpaRepository<MedicalTest, Integer> {
}