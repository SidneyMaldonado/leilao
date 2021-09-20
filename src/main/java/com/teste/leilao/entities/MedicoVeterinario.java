package com.teste.leilao.entities;

import java.util.List;

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
	public Integer ididmedicoveterinario;
	
	@Column(name= "nome")
	public String nome;
	
	@Column(name= "email")
	public String email;
	
	@Column(name= "telefone")
	public String telefone;

	return null;
	}
}
