package com.venue.booking.venue_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.venue.booking.venue_service.entity.VenueEntity;
import com.venue.booking.venue_service.service.VenueService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
    
    @Autowired
    private VenueService venueService;
    
    @GetMapping
    public ResponseEntity<List<VenueEntity>> getAllVenues() {
        return new ResponseEntity<>(venueService.getAllVenues(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<VenueEntity> getVenueById(@PathVariable("id") int venueId) {
        Optional<VenueEntity> venue = venueService.getVenueById(venueId);
        return venue.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<VenueEntity> addVenue(@RequestBody VenueEntity venue) {
        return new ResponseEntity<>(venueService.addVenue(venue), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<VenueEntity> updateVenue(@PathVariable("id") int venueId, 
                                                 @RequestBody VenueEntity venue) {
        venue.setVenueId(venueId);
        return new ResponseEntity<>(venueService.updateVenue(venue), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenue(@PathVariable("id") int venueId) {
        venueService.deleteVenue(venueId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/available/{status}")
    public ResponseEntity<List<VenueEntity>> getVenuesByAvailability(
            @PathVariable("status") boolean status) {
        return new ResponseEntity<>(venueService.getVenuesByAvailability(status), 
                                  HttpStatus.OK);
    }
    
    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Long>> getVenueStatistics() {
        return new ResponseEntity<>(venueService.getVenueStatistics(), HttpStatus.OK);
    }
}