package com.teste.leilao.controller;

import com.teste.leilao.Mensagem;
import com.teste.leilao.biz.PessoaBiz;
import com.teste.leilao.entities.Pessoa;
import com.teste.leilao.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> Get() {
        return pessoaRepository.findAll();
    }


    @PostMapping
    public Mensagem add(@RequestBody Pessoa pessoa) {
        PessoaBiz pessoaBiz = new PessoaBiz();
        pessoa.setIdPessoa(0);

        try {

            if (pessoaBiz.Validade(pessoa)) {
                this.pessoaRepository.save(pessoa);
                this.pessoaRepository.flush();
            } else {
                return PessoaBiz.msg;
            }
        } catch (Exception e) {
            PessoaBiz.msg.mensagens.add(e.getMessage());
            return PessoaBiz.msg;
        }
        PessoaBiz.msg.mensagens.add("OK");

        return PessoaBiz.msg;


    }
}
