package br.org.serratec.biblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "usuario")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId", scope = Usuario.class)
public class Usuario {
	// ---chave primaria---
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	// ---atributos---
	@NotBlank
	@Column(name = "user_nome")
	private String userNome;

	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email address")
	@Column(name = "user_email", unique = true)
	private String userEmail;

	@NotBlank
	@Column(name = "user_password")
	private String userPassword;

	// ---relação---
	@ManyToOne
	@JoinColumn(name = "perfil_id")
	private Perfil perfil;

	// ---construtor---
	public Usuario() {
	}

	public Usuario(Integer userId, String userNome, String userEmail, String userPassword, Perfil perfil) {
		this.userId = userId;
		this.userNome = userNome;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.perfil = perfil;
	}

	// ---Get&Set---
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserNome() {
		return userNome;
	}

	public void setUserNome(String userNome) {
		this.userNome = userNome;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
