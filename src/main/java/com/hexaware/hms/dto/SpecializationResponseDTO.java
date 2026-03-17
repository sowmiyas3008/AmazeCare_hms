package com.hexaware.hms.dto;

public class SpecializationResponseDTO {

    private int specializationId;
    private String name;

    public SpecializationResponseDTO() {}

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}