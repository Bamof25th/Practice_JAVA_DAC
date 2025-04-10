package com.app.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contact {
	private List<String> phnos;
	private String name;
	private LocalDate dob; // u
	private String email; // optional

	public Contact(ArrayList<String> phnos, String name, LocalDate dob, String email) {
		this.phnos = phnos;
		this.name = name;
		this.dob = dob;
		if (email != null && !email.isEmpty())
			this.email = email;
		else
			this.email = "not provided";
	}

	public List<String> getPhnos() {
		// phnos.stream().forEach(System.out::println);
		return phnos;
	}

	public void setPhnos(List<String> phnos) {
		this.phnos = phnos;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		// this.getPhnos();
		return "Contact [phnos=" + phnos + ", name=" + name + ", dob=" + dob + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dob, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(phnos, other.phnos);
	}

}
