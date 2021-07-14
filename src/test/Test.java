package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		ReservationManager model = new ReservationManager();

		model.addMed("jerry", "kwon", "pass123");

		// System.out.println("Number of meds: " + model.medici.size() + "\n");

		System.out.println(model.takeReservation("John", "Smith", "jhonsmith@gmail.com", "JHNSMT0201023EP",
				LocalDate.parse("10/01/2020", formatter), 11, "Can't breath", "jerry", "kwon"));
		// will give true

		System.out.println(model.takeReservation("lala", "hamtaro", "hamtaro@yahoo.com", "LLHMT0220030LM",
				LocalDate.parse("30/06/2021", formatter), 10, "Pancreas problem", "jerry", "kwon"));
		// will give true

		// System.out.println("Number of patients: " + model.pazienti.size() + "\n");

		System.out.println(model.takeReservation("John", "Smith", "jhonsmith@gmail.com", "JHNSMT0201023EP",
				LocalDate.parse("10/09/2020", formatter), 11, "This will give false", "jerry", "kwon"));
		// will give false

		model.addMed("mario", "red", "pass000");

		System.out.println(model.takeReservation("John", "Smith", "jhonsmith@gmail.com", "JHNSMT0201023EP",
				LocalDate.parse("10/09/2020", formatter), 11, "This will give true", "mario", "red"));
		// will give true

		model.showMeds();
		model.showPatients();
		model.showPatientsReservations();
		model.showMedsAppointments();

	}
}
