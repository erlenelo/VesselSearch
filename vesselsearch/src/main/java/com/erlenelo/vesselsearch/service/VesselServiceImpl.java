package com.erlenelo.vesselsearch.service;

import com.erlenelo.vesselsearch.model.Vessel;
import com.erlenelo.vesselsearch.repository.VesselRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VesselServiceImpl implements VesselService{

    @Autowired
    private VesselRepository vesselRepository;
    
    public VesselServiceImpl(VesselRepository vesselRepository) {
    this.vesselRepository = vesselRepository;
    }

    @Override
    public Vessel saveVessel(Vessel vessel) {

        return vesselRepository.save(vessel);
    }
    @Override
    public List<Vessel> getAllVessels() {
        return vesselRepository.findAll();
    }
    @Override
    public List<Vessel> getAllVesselsWithCertificates() {
        return vesselRepository.findAll();
    }
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

