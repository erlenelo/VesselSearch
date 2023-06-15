package com.erlenelo.vesselsearch.service;

import java.util.List;

import com.erlenelo.vesselsearch.model.Vessel;

public interface VesselService {
    public Vessel saveVessel (Vessel vessel);
    public List<Vessel> getAllVessels();
    public List<Vessel>getAllVesselsWithCertificates();
    public List<Vessel> searchVessels(String searchTerm);
}
