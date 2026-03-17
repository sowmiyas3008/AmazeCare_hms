package com.hexaware.hms.dto;

public class ConsultationTestResponseDTO {

    private int id;
    private int consultationId;
    private int testId;

    public ConsultationTestResponseDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }
}