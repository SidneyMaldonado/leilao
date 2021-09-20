package com.teste.leilao.biz;

import org.springframework.beans.factory.annotation.Autowired;

import com.teste.leilao.Mensagem;
import com.teste.leilao.entities.Animal;




public class AnimalBiz {

	public Mensagem msg;
	
	@Autowired
	public LeilaoRepository leilaoRepositorio;
	
	@Autowired
	public MedicoVeterinarioRepository medicoVeterinarioRepositorio;
	
	public AnimalBiz(LeilaoRepository leilaoRepo, MedicoVeterinarioRepository medicoVeterinarioRepo) {
		this.leilaoRepositorio = leilaoRepo;
		this.medicoVeterinarioRepositorio = medicoVeterinarioRepo;
		msg = new Mensagem();
	}
	
	public Boolean Validade(Animal animal) {
		
		Boolean result = true;
		if (animal.getNome().isEmpty()) {
			msg.mensagens.add("O nome do animal não pode ser vazio");
			result = false;
		}
		
		if (leilaoRepositorio.findById( animal.getIdLeilao() ).isEmpty()) {
			msg.mensagens.add( "O leilão escolhido não é válido");
			result = false;
		}
		
		if (medicoVeterinarioRepositorio.findById( animal.getIdMedicoVeterinario() ).isEmpty()) {
			msg.mensagens.add( "O Medico Veterinario escolhido não é válido");
			result = false;
		}
		
		if (animal.getPreco() < 0) {
			msg.mensagens.add( "O Preco não pode ser negativo");
			result = false;
		}
	}
}
