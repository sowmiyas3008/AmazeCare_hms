package com.hexaware.hms.service;

import java.util.List;
import com.hexaware.hms.entity.Specialization;

public interface ISpecializationService {

    Specialization addSpecialization(Specialization specialization);

    Specialization getById(int id);

    List<Specialization> getAll();

    Specialization updateSpecialization(Specialization specialization);

    void deleteSpecialization(int id);

    int getDoctorCount(int specializationId);
}