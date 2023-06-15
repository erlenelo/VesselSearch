package com.erlenelo.vesselsearch.service;

import com.erlenelo.vesselsearch.model.Vessel;
import com.erlenelo.vesselsearch.repository.VesselRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the VesselService interface.
 */
@Service
public class VesselServiceImpl implements VesselService {

    private VesselRepository vesselRepository;

    /**
     * Constructs a VesselServiceImpl with the specified VesselRepository.
     *
     * @param vesselRepository the repository for vessel data access
     */
    @Autowired
    public VesselServiceImpl(VesselRepository vesselRepository) {
        this.vesselRepository = vesselRepository;
    }

    /**
     * Saves a vessel.
     *
     * @param vessel the vessel to save
     * @return the saved vessel
     */
    @Override
    public Vessel saveVessel(Vessel vessel) {
        return vesselRepository.save(vessel);
    }

    /**
     * Retrieves all vessels.
     *
     * @return a list of all vessels
     */
    @Override
    public List<Vessel> getAllVessels() {
        return vesselRepository.findAll();
    }

    /**
     * Retrieves all vessels with associated certificates.
     *
     * @return a list of all vessels with certificates
     */
    @Override
    public List<Vessel> getAllVesselsWithCertificates() {
        return vesselRepository.findAll();
    }

    /**
     * Searches vessels based on a search term.
     *
     * @param searchTerm the term to search for in vessel names or IMOnumbers. The parseInt() method 
     * determines whether the search term is an IMO number or a vessel name.  
     * @return a list of vessels matching the search criteria
     */
    @Override
    public List<Vessel> searchVessels(String searchTerm) {
        try {
            int imoNumber = Integer.parseInt(searchTerm);
            return vesselRepository.findByVesselNameContainingIgnoreCaseOrImoNumber(searchTerm, imoNumber);
        } catch (NumberFormatException e) {
            return vesselRepository.findByVesselNameContainingIgnoreCase(searchTerm);
        }
    }
}