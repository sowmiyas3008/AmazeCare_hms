package com.hexaware.hms.dto;

public class MedicineResponseDTO {

    private int medicineId;
    private String name;

    public MedicineResponseDTO() {}

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}