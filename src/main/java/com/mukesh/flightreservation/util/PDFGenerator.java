package com.mukesh.flightreservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mukesh.flightreservation.entities.Reservation;

@Component
public class PDFGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);

	public void generateItineray(Reservation reservation, String filepath) {

		LOGGER.info("generateItineray()");
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filepath));
			document.open();

			document.add(generateTable(reservation));

			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			LOGGER.error("Exception in generateItineray " + e);
		}
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2);

		PdfPCell cell;
		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("AirLines");
		table.addCell(reservation.getFlight().getOperatingAirlines());

		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());

		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());

		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());

		table.addCell("Departure Date");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());

		table.addCell("Departure Time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());

		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());

		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());

		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());

		return table;
	}
}
