package com.hexaware.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.ISpecializationDAO;
import com.hexaware.hms.entity.Specialization;
import com.hexaware.hms.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

    @Autowired
    private ISpecializationDAO specializationDAO;

    @Override
    public Specialization addSpecialization(Specialization specialization) {
        return specializationDAO.save(specialization);
    }

    @Override
    public Specialization getById(int id) {
        return specializationDAO.findById(id).orElse(null);
    }

    @Override
    public List<Specialization> getAll() {
        return specializationDAO.findAll();
    }

    @Override
    public Specialization updateSpecialization(Specialization specialization) {
        Optional<Specialization> existing = specializationDAO.findById(specialization.getSpecializationId());

        if (existing.isPresent()) {
            Specialization s = existing.get();
            s.setName(specialization.getName());
            return specializationDAO.save(s);
        }
        return null;
    }

    @Override
    public void deleteSpecialization(int id) {
        specializationDAO.deleteById(id);
    }

    @Override
    public int getDoctorCount(int specializationId) {
        return specializationDAO.countDoctorsBySpecialization(specializationId);
    }
}