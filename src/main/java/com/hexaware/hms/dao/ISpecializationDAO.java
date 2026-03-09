package com.hexaware.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.hms.entity.Specialization;

public interface ISpecializationDAO extends JpaRepository<Specialization, Integer> {

    @Query("SELECT COUNT(d) FROM Doctor d WHERE d.specialization.specializationId = :id")
    int countDoctorsBySpecialization(@Param("id") int specializationId);
}