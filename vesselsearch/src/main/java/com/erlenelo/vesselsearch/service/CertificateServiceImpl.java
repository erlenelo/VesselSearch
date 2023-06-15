package com.erlenelo.vesselsearch.service;

import com.erlenelo.vesselsearch.model.Certificate;
import com.erlenelo.vesselsearch.repository.CertificateRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService{

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }
    @Override
    public Certificate saveCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }
    @Override
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }    

}
