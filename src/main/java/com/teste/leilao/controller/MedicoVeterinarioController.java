package com.teste.leilao.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.leilao.Mensagem;
import com.teste.leilao.biz.MedicoVeterinarioBiz;
import com.teste.leilao.entities.MedicoVeterinario;
import com.teste.leilao.repositories.MedicoVeterinarioRepository;

@RestController
@RequestMapping("medicoveterinario")
public class MedicoVeterinarioController<AnimalRepository, Animal> {


    @Autowired
    private MedicoVeterinarioRepository medicoveterinarioRepository;

    @Autowired
    private AnimalRepository animalRepository;
  

    @GetMapping("listar")
    public List<MedicoVeterinario> listar(){

        List<MedicoVeterinario> lista = MedicoVeterinarioRepository.findAll();
        return lista;

    }

    @PostMapping("incluir")
    public Mensagem salvar(@RequestBody MedicoVeterinario medicoveterinario ) {

    	medicoveterinario.setIdInstrumento(0);
    	MedicoVeterinarioBiz instrumentoBiz = new MedicoVeterinarioBiz(AnimalRepository);

        try {

            if (medicoveterinarioBiz.Validade(medicoveterinario)) {
                this.medicoveterinarioRepository.save(medicoveterinario);
                this.medicoveterinarioRepository.flush();
            } else {
                return medicoveterinarioBiz.msg;
            }
        } catch (Exception e) {
        	medicoveterinarioBiz.msg.mensagens.add(e.getMessage());
            return medicoveterinarioBiz.msg;
        }
        medicoveterinarioBiz.msg.mensagens.add("OK");

        return medicoveterinarioBiz.msg;

    }

}

