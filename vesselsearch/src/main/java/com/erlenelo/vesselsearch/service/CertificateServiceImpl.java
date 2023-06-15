package com.erlenelo.vesselsearch.service;
import com.erlenelo.vesselsearch.model.Certificate;
import com.erlenelo.vesselsearch.repository.CertificateRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the CertificateService interface.
 */
@Service
public class CertificateServiceImpl implements CertificateService {

    private CertificateRepository certificateRepository;

    /**
     * Constructs a CertificateServiceImpl with the specified CertificateRepository.
     *
     * @param certificateRepository the repository for certificate data access
     */
    @Autowired
    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    /**
     * Saves a certificate.
     *
     * @param certificate the certificate to save
     * @return the saved certificate
     */
    @Override
    public Certificate saveCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    /**
     * Retrieves all certificates.
     *
     * @return a list of all certificates
     */
    @Override
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }
}