package com.teste.leilao.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicoveterinario")
public class MedicoVeterinario {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name= "idmedicoveterinario")
	private Integer ididmedicoveterinario;
	
	@Column(name= "nome")
	private String nome;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "telefone")
	private String telefone;

	public Integer getIdidmedicoveterinario() {
		return ididmedicoveterinario;
	}

	public void setIdidmedicoveterinario(Integer ididmedicoveterinario) {
		this.ididmedicoveterinario = ididmedicoveterinario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
}
