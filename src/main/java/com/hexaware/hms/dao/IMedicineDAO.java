package com.hexaware.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.hms.entity.Medicine;

public interface IMedicineDAO extends JpaRepository<Medicine, Integer> {
}