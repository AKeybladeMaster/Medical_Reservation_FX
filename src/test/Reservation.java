package test;

import java.time.LocalDate;

public class Reservation {

	private LocalDate date;
	private int schedule;
	private String type_of_reservation;
	private Med med;

	public Reservation(LocalDate date, int schedule, String type_of_reservation, Med med) {
		this.date = date;
		this.schedule = schedule;
		this.type_of_reservation = type_of_reservation;
		this.med = med;
	}

	public LocalDate getData() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getSchedule() {
		return schedule;
	}

	public void setSchedule(int schedule) {
		this.schedule = schedule;
	}

	public String getType_of_reservation() {
		return type_of_reservation;
	}

	public void setType_of_reservation(String type_of_reservation) {
		this.type_of_reservation = type_of_reservation;
	}

	public Med getMed() {
		return med;
	}

	public void setMed(Med med) {
		this.med = med;
	}

	@Override
	public String toString() {
		return "Reservation - date=[" + date + "], scheduled at=[" + schedule + "], type=[" + type_of_reservation
				+ "], Med=[" + med.getName() + " " + med.getSurname() + "]";
	}

}
