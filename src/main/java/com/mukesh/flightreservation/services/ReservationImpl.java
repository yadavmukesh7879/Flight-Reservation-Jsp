package com.mukesh.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mukesh.flightreservation.dto.ReservationRequest;
import com.mukesh.flightreservation.entities.Flight;
import com.mukesh.flightreservation.entities.Passenger;
import com.mukesh.flightreservation.entities.Reservation;
import com.mukesh.flightreservation.repos.FlightRepository;
import com.mukesh.flightreservation.repos.PassengerRepository;
import com.mukesh.flightreservation.repos.ReservationRepository;
import com.mukesh.flightreservation.util.EmailUtil;
import com.mukesh.flightreservation.util.PDFGenerator;

@Service
public class ReservationImpl implements ReservationService {
	@Value("${C:/Users/mukes/Desktop/reservationdetails/Reservation Details}")
	private String ITINERARY_DIR;
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	PDFGenerator pdfGenerator;
	@Autowired
	EmailUtil emailUtil;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationImpl.class);

	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {

		LOGGER.info("Inside bookFlight()");

		// Make Payment

		Long flightId = request.getFlightId();
		LOGGER.info("Fetching flight for flight id:" + flightId);
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		LOGGER.info("Saving the passenger :" + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setCheckedIn(false);
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		LOGGER.info("Saving the reservation :" + reservation);
		Reservation savedReservation = reservationRepository.save(reservation);

		String filepath = ITINERARY_DIR + reservation.getId() + ".pdf";
		LOGGER.info("Generating the itinerary");
		pdfGenerator.generateItineray(savedReservation, filepath);
		LOGGER.info("Emailing the itinerary");
		emailUtil.sendItinerary(passenger.getEmail(), filepath);

		return savedReservation;

	}

}
