package com.hexaware.hms.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "consultation_tests")
public class ConsultationTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="consultation_id")
    private int consultationId;
    
    @Column(name="test_id")
    private int testId;

    public ConsultationTest() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getConsultationId() { return consultationId; }
    public void setConsultationId(int consultationId) { this.consultationId = consultationId; }

    public int getTestId() { return testId; }
    public void setTestId(int testId) { this.testId = testId; }
}
