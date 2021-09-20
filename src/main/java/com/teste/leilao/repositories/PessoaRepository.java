package com.teste.leilao.repositories;

import com.teste.leilao.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Integer>{

}
