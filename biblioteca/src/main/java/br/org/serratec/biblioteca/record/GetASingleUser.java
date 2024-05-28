package br.org.serratec.biblioteca.record;

public record GetASingleUser(
		String id,
		String email,
		String username,
		String password,
		Name name,
		Adress address,
		String phone
		) {

	public String phone() {
		return phone;
	}

	public String id() {
		return id;
	}

	public String email() {
		return email;
	}

	public String username() {
		return username;
	}

	public String password() {
		return password;
	}

}
