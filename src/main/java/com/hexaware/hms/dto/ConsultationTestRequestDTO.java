package com.hexaware.hms.dto;

public class ConsultationTestRequestDTO {

    private int consultationId;
    private int testId;

    public ConsultationTestRequestDTO() {}

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