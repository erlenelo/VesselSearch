package com.erlenelo.vesselsearch.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


@Entity
@Table(name="vessel")
public class Vessel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vesselId;
    private String vesselName;
    private int imoNumber;

    @OneToMany(mappedBy="vessel", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Certificate> certificates;

    public Vessel() {

    }

    public void setVesselId(int vesselId) {
        this.vesselId = vesselId;
    }

    public int getVesselId() {
        return vesselId;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getVesselName() {
        return vesselName;
    }
    public void setImoNumber(int imoNumber) {
        this.imoNumber = imoNumber;
    }
    public int getImoNumber() {
        return imoNumber;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
    @JsonManagedReference
    public List<Certificate> getCertificates() {
        return certificates;
    }
}