package br.org.serratec.biblioteca.record;

import br.org.serratec.biblioteca.dtos.Geolocation;

public record Adress(
		String city, 
		String street, 
		String number, 
		String zipcode,
		Geolocation geolocation) {

	public String city() {
		return city;
	}

	public String street() {
		return street;
	}

	public String number() {
		return number;
	}

	public String zipcode() {
		return zipcode;
	}

}
