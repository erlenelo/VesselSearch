package com.erlenelo.vesselsearch.service;

import com.erlenelo.vesselsearch.model.Vessel;

import java.util.List;

/**
 * The service interface for managing vessels.
 */
public interface VesselService {

    /**
     * Saves a vessel.
     *
     * @param vessel the vessel to save
     * @return the saved vessel
     */
    public Vessel saveVessel(Vessel vessel);

    /**
     * Retrieves all vessels.
     *
     * @return a list of all vessels
     */
    public List<Vessel> getAllVessels();

    /**
     * Retrieves all vessels with associated certificates.
     *
     * @return a list of all vessels with certificates
     */
    public List<Vessel> getAllVesselsWithCertificates();

    /**
     * Searches vessels based on a search term.
     *
     * @param searchTerm the term to search for in vessel names or IMOnumbers
     * @return a list of vessels matching the search criteria
     */
    public List<Vessel> searchVessels(String searchTerm);

}