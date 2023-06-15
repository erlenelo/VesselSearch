package com.erlenelo.vesselsearch.repository;

import com.erlenelo.vesselsearch.model.Certificate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The repository interface for accessing certificate data in the database.
 */
@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

}
