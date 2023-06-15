package com.erlenelo.vesselsearch.repository;

import com.erlenelo.vesselsearch.model.Certificate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

}
