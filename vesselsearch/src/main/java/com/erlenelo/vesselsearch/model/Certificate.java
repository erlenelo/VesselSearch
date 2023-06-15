package com.erlenelo.vesselsearch.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The Certificate class represents a certificate associated with a vessel.
 */
@Entity
@Table(name="certificate")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int certificateId;
    private String certificateName;
    private String certificateType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vesselId")
    @JsonIgnoreProperties("certificates")
    @JsonBackReference
    private Vessel vessel;

    public Certificate() {

    }
    public int getCertificateId() {
        return certificateId;
    }
    public void setCertificateId(int certificateId) {
        this.certificateId = certificateId;
    }
    public String getCertificateName() {
        return certificateName;
    }
    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public void setCertificateType(String certificateType){
        this.certificateType = certificateType;
    }
    public String getCertificateType(){
        return certificateType;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate(){
        return endDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }
    /**
     * Retrieves the vessel associated with the certificate.
     *
     * @return the vessel associated with the certificate
     */
    public Vessel getVessel() {
        return vessel;
    }
    /**
     * Sets the vessel associated with the certificate.
     *
     * @param vessel the vessel to be set as the associated vessel
     */
    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

}

