package com.hexaware.hms.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "specializations")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialization_id")
    private int specializationId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // 🔥 One specialization → many doctors
    @OneToMany(mappedBy = "specialization", fetch = FetchType.LAZY)
    private List<Doctor> doctors;
    
    public Specialization() {}

    public int getSpecializationId() { return specializationId; }
    public void setSpecializationId(int specializationId) { this.specializationId = specializationId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
