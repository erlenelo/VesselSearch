package com.erlenelo.vesselsearch.service;

import java.util.List;

import com.erlenelo.vesselsearch.model.Certificate;

public interface CertificateService {
    public Certificate saveCertificate (Certificate certificate);
    public List<Certificate> getAllCertificates();

}