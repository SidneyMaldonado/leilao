package com.teste.leilao.biz;

import javax.validation.*;

import java.util.Set;

public class FazendaBiz {
    public Mensagem msg;

    private PessoaRepository pessoaRepository;
 
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = factory.getValidator();

    public FazendaBiz(PessoaRepository pessoaRepository) {
        msg = new Mensagem();
        this.pessoaRepository = pessoaRepository;
    }

    public Boolean Validade(Fazenda fazenda) {

        Set<ConstraintViolation<Fazenda>> constraintViolationSet = validator.validate(fazenda);

        Boolean result = true;
        if (fazenda.getNomeInstrumento().isEmpty()) {
            msg.mensagens.add("O nome da fazenda não pode ser vazio");
            result = false;
        }
        if (fazenda.getNomeInstrumento().startsWith("PP")) {
            msg.mensagens.add("O nome da fazenda é inválido");
            result = false;
        }
        if (pessoaRepository.findById(fazenda.getIdOrquestra()).isEmpty()) {
            msg.mensagens.add("Id inexistente");
            result = false;
        }      
        if(!constraintViolationSet.isEmpty()){
            ConstraintViolationException exceptionConstraint = new ConstraintViolationException(constraintViolationSet);
            msg.mensagens.add(exceptionConstraint.getMessage());
            result = false;
        }
        if(result == true){
            msg.mensagens.add("OK");
        }


        return result;

    }

}
