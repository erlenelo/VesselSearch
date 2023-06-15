package com.erlenelo.vesselsearch.controller;
import com.erlenelo.vesselsearch.model.Certificate;
import com.erlenelo.vesselsearch.service.CertificateService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * The controller class that handles HTTP requests related to certificates.
 */
@RestController
@RequestMapping("/certificate")
@CrossOrigin
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    /**
     * Constructs a new instance of CertificateController.
     *
     * @param certificateService the service responsible for handling certificate-related operations
     */
    @Autowired
    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    /**
     * Adds a new certificate.
     *
     * @param certificate the certificate object to be added
     * @return a string indicating the result of the operation
     */
    @PostMapping("/add")
    public String add(@RequestBody Certificate certificate){
        certificateService.saveCertificate(certificate);
        return "New certificate added";
    }

    /**
     * Retrieves all certificates. Currently not used.
     *
     * @return a list of all certificates
     */
    @GetMapping("/getAll")
    public List<Certificate> getAll(){
        return certificateService.getAllCertificates();
    }

}