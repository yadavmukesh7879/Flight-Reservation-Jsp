package com.mukesh.flightreservation.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mukesh.flightreservation.entities.Flight;
import com.mukesh.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	@Autowired
	private FlightRepository flightRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@RequestMapping("admin/showAddFlight")
	public String regiFlight() {
		LOGGER.info("Inside regiFlight()");
		return "addFlight";
	}

	@RequestMapping(value = "/admin/addFlight", method = RequestMethod.POST)
	public String addFlight(@ModelAttribute("Flight") Flight flight) {
		LOGGER.info("Inside regiFlight()" + flight);
		flightRepository.save(flight);
		return "addFlight";
	}

	@RequestMapping(value = "findFlights", method = RequestMethod.POST)
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date departureDate,
			ModelMap modelMap) {

		LOGGER.info("Inside findflight() From " + from + "To" + to + "Departure date" + departureDate);
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		modelMap.addAttribute("flights", flights);
		LOGGER.info("Flight found are:" + flights);
		return "displayFlights";

	}
}
