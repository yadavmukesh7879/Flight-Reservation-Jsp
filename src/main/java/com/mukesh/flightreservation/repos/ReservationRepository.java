package com.mukesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mukesh.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
