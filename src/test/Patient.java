package test;

import java.util.ArrayList;
import java.util.List;

public class Patient {
	private String name, surname, email, citizen_id;
	private List<Reservation> reservations;

	public Patient(String name, String surname, String email, String citizen_id) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.citizen_id = citizen_id;
		this.reservations = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCitizen_id() {
		return citizen_id;
	}

	public void setCitizen_id(String citizen_id) {
		this.citizen_id = citizen_id;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	@Override
	public String toString() {
		return "Patient - name=[" + name + "], surname=[" + surname + "], email=[" + email + "], citizen id=["
				+ citizen_id + "]";
	}
}
