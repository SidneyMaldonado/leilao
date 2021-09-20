package com.teste.leilao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.leilao.repositories.VendaRepository;



@RestController
@RequestMapping("venda")
public class VendaController {
	
	@Autowired
	private VendaRepository vendaRepositorio;
	
	@Autowired
	private CompradorRepository compradorRepositorio;
	
	@Autowired 
	private VendedorRepository vendedorRepositorio;
	
	@Autowired 
	private AnimalRepository animalRepositorio;
	

}
