package com.venue.booking.venue_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="venue_service")
public class VenueEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="venue_id")
    private int venueId;
    
    @Column(name="venue_name", unique = true)
    private String venueName;
    
    @Column(name="venue_building")
    private String venueBuilding;
    
    @Column(name="venue_floor")
    private String venueFloor;
    
    @Column(name="venue_capacity")
    private int venueCapacity;
    
    @Column(name="has_ac")
    private boolean hasAc;
    
    @Column(name="has_projector")
    private boolean hasProjector;
    
    @Column(name="venue_available")
    private boolean venueAvailable;
}