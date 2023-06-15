package com.erlenelo.vesselsearch.repository;

import com.erlenelo.vesselsearch.model.Vessel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface VesselRepository extends JpaRepository<Vessel, Integer> {
    List<Vessel> findByVesselNameContainingIgnoreCaseOrImoNumber(String vesselName, int imoNumber);
    List<Vessel> findByVesselNameContainingIgnoreCase(String vesselName);
}
