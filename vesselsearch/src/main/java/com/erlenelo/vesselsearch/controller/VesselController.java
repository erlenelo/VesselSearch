package com.erlenelo.vesselsearch.controller;

import com.erlenelo.vesselsearch.model.Vessel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erlenelo.vesselsearch.service.VesselService;

@RestController
@RequestMapping("/vessel")
public class VesselController {
    @Autowired
    private VesselService vesselService;

    public VesselController(VesselService vesselService) {
        this.vesselService = vesselService;
    }

    @PostMapping("/add")
    public String add(@RequestBody Vessel vessel){
        vesselService.saveVessel(vessel);
        return "New vessel added";
    }

    @GetMapping("/getAll")
    public List<Vessel> getAll(){
        return vesselService.getAllVessels();
    }
    @GetMapping("/getAllWithCertificates")
    public List<Vessel> getAllWithCertificates() {
    return vesselService.getAllVesselsWithCertificates();
    }
        @GetMapping("/search")
    public ResponseEntity<List<Vessel>> searchVessels(@RequestParam("searchTerm") String searchTerm) {
        List<Vessel> vessels = vesselService.searchVessels(searchTerm);
        return ResponseEntity.ok(vessels);
    }
    
}
