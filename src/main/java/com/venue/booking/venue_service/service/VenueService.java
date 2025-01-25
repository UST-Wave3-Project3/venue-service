package com.venue.booking.venue_service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venue.booking.venue_service.entity.VenueEntity;
import com.venue.booking.venue_service.repository.VenueRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VenueService {
    
    @Autowired
    private VenueRepository venueRepository;
    
    public List<VenueEntity> getAllVenues() {
        return venueRepository.findAll();
    }
    
    public VenueEntity addVenue(VenueEntity newVenue) {
        return venueRepository.saveAndFlush(newVenue);
    }
    
    public VenueEntity updateVenue(VenueEntity editVenue) {
        return venueRepository.save(editVenue);
    }
    
    public void deleteVenue(int vId) {
        venueRepository.deleteById(vId);
    }
    
    public List<VenueEntity> getVenuesByAvailability(boolean availability) {
        return venueRepository.findByVenueAvailable(availability);
    }
    
    public Map<String, Long> getVenueStatistics() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalVenues", venueRepository.countTotalVenues());
        stats.put("availableCount", venueRepository.countAvailableVenues());
        stats.put("notAvailableCount", venueRepository.countUnavailableVenues());
        stats.put("projectorCount", venueRepository.countVenuesWithProjector());
        stats.put("acCount", venueRepository.countVenuesWithAc());
        return stats;
    }
    
    public Optional<VenueEntity> getVenueById(int venueId) {
        return venueRepository.findById(venueId);
    }
}