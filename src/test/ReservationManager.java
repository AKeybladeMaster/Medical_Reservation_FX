package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationManager {

	private List<Med> meds = new ArrayList<>();
	private List<Patient> patients = new ArrayList<>();

	// --------------------------- BEGIN OF PRINTING METHODS FOR MEDS AND PATIENTS
	// ---------------------------

	public void showMeds() {
		System.out.println("\n----------LIST OF MEDS----------");
		for (int i = 0; i < meds.size(); i++) {
			System.out.println(meds.get(i).toString());
		}
		System.out.println("------------------------------------");
	}

	public void showPatients() {
		System.out.println("\n----------LIST OF PATIENTS----------");
		for (int i = 0; i < patients.size(); i++) {
			System.out.println(patients.get(i).toString());
		}
		System.out.println("--------------------------------------");
	}

	public void showPatientsReservations() {
		System.out.println("\n----------LIST OF PATIENTS' RESERVATIONS----------");
		for (int i = 0; i < patients.size(); i++) {
			System.out.println(patients.get(i).toString());
			for (int j = 0; j < patients.get(i).getReservations().size(); j++) {
				System.out.println(patients.get(i).getReservations().get(j).toString());
			}
			System.out.println("---------------------------------------------------------");
		}
	}

	public void showMedsAppointments() {
		System.out.println("\n----------LIST OF MEDS' APPOINTMENTS----------");
		for (int i = 0; i < meds.size(); i++) {
			System.out.println(meds.get(i).toString());
			for (int j = 0; j < meds.get(i).getAppointments().size(); j++) {
				System.out.println("\n" + meds.get(i).getAppointments().get(j).toString());
				for (int k = 0; k < meds.get(i).getAppointments().get(j).getReservations().size(); k++) {
					if (meds.get(i).getAppointments().get(j).getReservations().get(k).getMed().getName()
							.equals(meds.get(i).getName())
							&& meds.get(i).getAppointments().get(j).getReservations().get(k).getMed().getSurname()
									.equals(meds.get(i).getSurname()))
						System.out.println(meds.get(i).getAppointments().get(j).getReservations().get(k).toString());
				}
			}
			System.out.println("-------------------------------------------------------");
		}
	}

	// --------------------------- END OF PRINTING METHODS ---------------------------

	// --------------------------- BEGIN OF MEDS METHODS ---------------------------

	public boolean addMed(String name, String surname, String password) {
		Med m = new Med(name, surname, password);
		for (int i = 0; i < meds.size(); i++) {
			if (m.equals(meds.get(i)))
				return false;
		}
		meds.add(m);
		return true;
	}

	public Med findMed(String name, String surname) {
		for (int i = 0; i < meds.size(); i++) {
			if (meds.get(i).getName().equals(name) && meds.get(i).getSurname().equals(surname))
				return meds.get(i);
		}
		return null;
	}

	// --------------------------- END OF MEDS METHODS ---------------------------

	// --------------------------- BEGIN OF PATIENT METHODS ---------------------------
	
	public Patient findPatient(String citizen_code) {
		for (int i = 0; i < patients.size(); i++) {
			if (patients.get(i).getCitizen_id() == citizen_code)
				return patients.get(i);
		}
		return null;
	}

	public boolean takeReservation(String name, String surname, String email, String citizen_id, LocalDate date,
			int time, String type_of_reservation, String med_name, String med_surname) {
		Med med = findMed(med_name, med_surname);
		if (med != null) {
			for (int i = 0; i < patients.size(); i++) {
				if (patients.get(i).getCitizen_id() == citizen_id) {
					if (reservationExists(med, citizen_id)) {
						return false;
					} else {
						med.getAppointments().add(patients.get(i));
						patients.get(i).getReservations().add(new Reservation(date, time, type_of_reservation, med));
						return true;
					}
				}
			}
		}
		if (reservationExists(med, citizen_id)) {
			return false;
		} else {
			Patient p = new Patient(name, surname, email, citizen_id);
			med.getAppointments().add(p);
			p.getReservations().add(new Reservation(date, time, type_of_reservation, med));
			patients.add(p);
			return true;
		}
	}

	private boolean reservationExists(Med med, String citizen_id) {
		for (int j = 0; j < med.getAppointments().size(); j++) {
			if (med.getAppointments().get(j).getCitizen_id() == citizen_id)
				return true;
		}
		return false;
	}
	// --------------------------- END OF PATIENT METHODS ---------------------------
}