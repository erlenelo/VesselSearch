package com.erlenelo.vesselsearch.service;

import java.util.List;

import com.erlenelo.vesselsearch.model.Certificate;

/**
 * The service interface for handling certificate-related operations.
 */
public interface CertificateService {
    /**
     * Saves a certificate.
     *
     * @param certificate the certificate to save
     * @return the saved certificate
     */
    public Certificate saveCertificate (Certificate certificate);
    
    /**
     * Retrieves all certificates.
     *
     * @return a list of all certificates
     */
    public List<Certificate> getAllCertificates();

}