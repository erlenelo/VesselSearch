package com.erlenelo.vesselsearch.controller;

import com.erlenelo.vesselsearch.model.Certificate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erlenelo.vesselsearch.service.CertificateService;

@RestController
@RequestMapping("/certificate")
@CrossOrigin
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    @Autowired
    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @PostMapping("/add")
    public String add(@RequestBody Certificate certificate){
        certificateService.saveCertificate(certificate);
        return "New certificate added";
    }

    @GetMapping("/getAll")
    public List<Certificate> getAll(){
        return certificateService.getAllCertificates();
    }

}