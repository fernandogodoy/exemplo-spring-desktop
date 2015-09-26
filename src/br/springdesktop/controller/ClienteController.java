package br.springdesktop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.springdesktop.dao.PessoaDao;
import br.springdesktop.modelo.Pessoa;

@Component
public class ClienteController {

	@Autowired
	private PessoaDao dao;
	
	public void salvar(Pessoa cliente){
		dao.salvar(cliente);
	}
	
}
