package br.org.serratec.biblioteca.record;

public record Name(
		String firstname, 
		String lastname
) {

	public String firstname() {
		return firstname;
	}

	public String lastname() {
		return lastname;
	}

}
