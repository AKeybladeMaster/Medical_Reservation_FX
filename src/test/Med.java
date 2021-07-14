package test;

import java.util.ArrayList;
import java.util.List;

public class Med {
	private String name, surname, ID, password;
	private List<Patient> appointments;

	public Med(String name, String surname, String password) {
		this.name = name;
		this.surname = surname;
		this.ID = generateID();
		this.password = password;
		this.appointments = new ArrayList<>();
	}

	private String generateID() {
		return Integer.toHexString((int) (Math.random() * (1000000 - 50000) + 50000));
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

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Patient> getAppointments() {
		return appointments;
	}

	@Override
	public String toString() {
		return "Med - name=[" + name + "], surname=[" + surname + "], ID=[" + ID + "], password=[" + password + "]";
	}
}
