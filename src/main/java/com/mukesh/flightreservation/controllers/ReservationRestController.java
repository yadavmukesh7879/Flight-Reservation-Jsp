package com.mukesh.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukesh.flightreservation.dto.UpdateReservationRequest;
import com.mukesh.flightreservation.entities.Reservation;
import com.mukesh.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	@Autowired
	private ReservationRepository reservationRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

	@RequestMapping("reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside findReservation() for id: " + id);
		Reservation reservation = reservationRepository.findById(id).get();
		return reservation;

	}

	@RequestMapping("reservations")
	public Reservation updateReservation(@RequestBody UpdateReservationRequest request) {
		LOGGER.info("Inside updateReservation() for :" + request);
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		LOGGER.info("Saving Reservation");
		return reservationRepository.save(reservation);

	}

}
