package com.venue.booking.venue_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.venue.booking.venue_service.entity.VenueEntity;
import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<VenueEntity, Integer> {
    
    List<VenueEntity> findByVenueAvailable(boolean venueAvailable);
    
    @Query("SELECT COUNT(v) FROM VenueEntity v")
    long countTotalVenues();
    
    @Query("SELECT COUNT(v) FROM VenueEntity v WHERE v.venueAvailable = true")
    long countAvailableVenues();
    
    @Query("SELECT COUNT(v) FROM VenueEntity v WHERE v.venueAvailable = false")
    long countUnavailableVenues();
    
    @Query("SELECT COUNT(v) FROM VenueEntity v WHERE v.hasProjector = true")
    long countVenuesWithProjector();
    
    @Query("SELECT COUNT(v) FROM VenueEntity v WHERE v.hasAc = true")
    long countVenuesWithAc();
}