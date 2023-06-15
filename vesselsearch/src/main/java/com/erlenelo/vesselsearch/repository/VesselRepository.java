package com.erlenelo.vesselsearch.repository;

import com.erlenelo.vesselsearch.model.Vessel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 * The repository interface for accessing vessel data in the database.
 */
@Repository
public interface VesselRepository extends JpaRepository<Vessel, Integer> {
    /**
     * Finds vessels by vessel name containing the specified name or IMO number.
     *
     * @param vesselName the name to search for in the vessel name
     * @param imoNumber the IMO number to search for
     * @return a list of vessels matching the search criteria
     */
    List<Vessel> findByVesselNameContainingIgnoreCaseOrImoNumber(String vesselName, int imoNumber);
    
    /**
     * Finds vessels by vessel name containing the specified name.
     *
     * @param vesselName the name to search for in the vessel name
     * @return a list of vessels matching the search criteria
     */
    List<Vessel> findByVesselNameContainingIgnoreCase(String vesselName);
}
