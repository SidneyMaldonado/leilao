package com.teste.leilao.biz;

import org.springframework.beans.factory.annotation.Autowired;

import com.teste.leilao.Mensagem;
import com.teste.leilao.entities.MedicoVeterinario;
import com.teste.leilao.repositories.AnimalRepository;



public class MedicoVeterinarioBiz {
	
	public Mensagem msg;
	
	@Autowired
	public AnimalRepository animalRepositorio;
	
	public MedicoVeterinarioBiz(AnimalRepository animalRepo) {
		this.animalRepositorio = animalRepo;
		msg = new Mensagem();
	}

	public Boolean Validade(MedicoVeterinario medicoveterinario) {
	
		Boolean result = true;
		if (medicoveterinario.getNome().isEmpty()) {
			msg.mensagens.add("O nome do Médico não pode ser vazio");
			result = false;
		}
		if (medicoveterinario.getNome().startsWith("PP")) {
			msg.mensagens.add("O nome do médico é inválido");
			result = false;
		}
		
		if (animalRepositorio.findById( animal.getCodigoSetor() ).isEmpty()) {
			msg.mensagens.add( "O animal escolhido não é válido");
			result = false;
		}
		
		return result;
		
	}

}
