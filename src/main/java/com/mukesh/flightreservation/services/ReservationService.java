package com.mukesh.flightreservation.services;

import com.mukesh.flightreservation.dto.ReservationRequest;
import com.mukesh.flightreservation.entities.Reservation;
public interface ReservationService {
	public Reservation bookFlight(ReservationRequest request);
}
