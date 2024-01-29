package com.mukesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mukesh.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
