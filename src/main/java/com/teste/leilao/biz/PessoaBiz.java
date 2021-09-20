package com.teste.leilao.biz;

import com.teste.leilao.Mensagem;
import com.teste.leilao.entities.Pessoa;

import javax.validation.*;
import java.util.Set;

public class PessoaBiz {

    public static Mensagem msg = new Mensagem();
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public Boolean Validade(Pessoa pessoa) {

        Set<ConstraintViolation<Pessoa>> constraintViolationSet = validator.validate(pessoa);

        boolean result = true;

        if (pessoa.getNome().isEmpty()) {
            msg.mensagens.add("O nome do instrumento não pode ser vazio");
            result = false;
        }
        if (pessoa.getNome().startsWith("PP")) {
            msg.mensagens.add("O nome do instrumento é inválido");
            result = false;
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
