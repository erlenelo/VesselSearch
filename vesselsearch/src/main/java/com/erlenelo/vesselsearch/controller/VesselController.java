package com.erlenelo.vesselsearch.controller;
import com.erlenelo.vesselsearch.model.Vessel;
import com.erlenelo.vesselsearch.service.VesselService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller class that handles HTTP requests related to vessels.
 */
@RestController
@RequestMapping("/vessel")
public class VesselController {
    @Autowired
    private VesselService vesselService;

    /**
     * Constructs a new instance of VesselController.
     *
     * @param vesselService the service responsible for handling vessel-related operations
     */
    public VesselController(VesselService vesselService) {
        this.vesselService = vesselService;
    }

    /**
     * Adds a new vessel.
     *
     * @param vessel the vessel object to be added
     * @return a string indicating the result of the operation
     */
    @PostMapping("/add")
    public String add(@RequestBody Vessel vessel){
        vesselService.saveVessel(vessel);
        return "New vessel added";
    }
    /**
     * Retrieves all vessels. Currently unused.
     *
     * @return a list of all vessels
     */
    @GetMapping("/getAll")
    public List<Vessel> getAll(){
        return vesselService.getAllVessels();
    }

    /**
     * Retrieves all vessels with certificates.
     *
     * @return a list of all vessels with their certificates
     */
    @GetMapping("/getAllWithCertificates")
    public List<Vessel> getAllWithCertificates() {
    return vesselService.getAllVesselsWithCertificates();
    }
    /**
     * Searches vessels based on a search term.
     *
     * @param searchTerm the term to search for in vessel names
     * @return a ResponseEntity containing a list of vessels matching the search term
     */
        @GetMapping("/search")
    public ResponseEntity<List<Vessel>> searchVessels(@RequestParam("searchTerm") String searchTerm) {
        List<Vessel> vessels = vesselService.searchVessels(searchTerm);
        return ResponseEntity.ok(vessels);
    }
    
}
