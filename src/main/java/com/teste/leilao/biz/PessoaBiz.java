package com.teste.leilao.biz;

import com.teste.leilao.Mensagem;
import com.teste.leilao.entities.Pessoa;
import com.teste.leilao.repositories.TipoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.*;
import java.util.Set;

public class PessoaBiz {

    public static Mensagem msg;

    @Autowired
    public TipoPessoaRepository tipoPessoaRepository;

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public PessoaBiz(){
        msg = new Mensagem();
    }

    public Boolean Validade(Pessoa pessoa) {

        Set<ConstraintViolation<Pessoa>> constraintViolationSet = validator.validate(pessoa);

        boolean result = true;

        if (pessoa.getNome().isEmpty()) {
            msg.mensagens.add("O nome da pessoa não pode ser vazio");
            result = false;
        }
        if (pessoa.getNome().startsWith("PP")) {
            msg.mensagens.add("O nome da pessoa é inválido");
            result = false;
        }

        if(tipoPessoaRepository.existsById(pessoa.getIdtipopessoa())){
            msg.mensagens.add("Esse tipo pessoa não existe");
        }

        if (!constraintViolationSet.isEmpty()) {
            ConstraintViolationException exceptionConstraint = new ConstraintViolationException(constraintViolationSet);
            msg.mensagens.add(exceptionConstraint.getMessage());
            result = false;
        }
        if (result) {
            msg.mensagens.add("OK");
        }


        return result;

    }
}
