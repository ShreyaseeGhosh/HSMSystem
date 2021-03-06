package com.example.SpringBackend.database.entities;

import javax.persistence.*;

import com.example.SpringBackend.database.enums.ComplainStage;

@Entity
public class Complains {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long complain_id;
    @Column(nullable = false)
    private String details;
    private String raised_on;
    @Enumerated(EnumType.STRING)
    private ComplainStage status;
    
    @OneToOne
    @JoinColumn(name = "residence_ref")
    private Residences residence_ref;

    public Complains() {
    }

    public Complains(String details, String raised_on, ComplainStage status) {
        this.details = details;
        this.raised_on = raised_on;
        this.status = status;
    }
    
    public Complains(long complain_id, String details, String raised_on, ComplainStage status,
            Residences residence_ref) {
        this.complain_id = complain_id;
        this.details = details;
        this.raised_on = raised_on;
        this.status = status;
        this.residence_ref = residence_ref;
    }

    public long getComplain_id() {
        return this.complain_id;
    }

    public void setComplain_id(long complain_id) {
        this.complain_id = complain_id;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRaised_on() {
        return this.raised_on;
    }

    public void setRaised_on(String raised_on) {
        this.raised_on = raised_on;
    }

    public ComplainStage getStatus() {
        return this.status;
    }

    public void setStatus(ComplainStage status) {
        this.status = status;
    }

    public Residences getResidence_ref() {
        return residence_ref;
    }

    public void setResidence_ref(Residences residence_ref) {
        this.residence_ref = residence_ref;
    }

    @Override
    public String toString() {
        return "Complains [complain_id=" + complain_id + ", details=" + details + ", raised_on=" + raised_on
                + ", residence_ref=" + residence_ref + ", status=" + status + "]";
    }

}
