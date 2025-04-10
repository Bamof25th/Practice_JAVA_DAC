package com.app.core;

import java.util.Objects;

public class Key {
	private String name;
	private String dob;

	public Key(String name, String dob) {
		this.name = name;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Key [name=" + name + ", dob=" + dob + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Key other = (Key) obj;
		return Objects.equals(name, other.name) && Objects.equals(dob, other.dob);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, dob);
	}

}
