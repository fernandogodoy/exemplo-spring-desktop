package br.springdesktop.dao;

import org.springframework.stereotype.Component;

import br.springdesktop.modelo.Pessoa;

@Component
public class PessoaDao extends GenericDao<Pessoa>{

	public PessoaDao() {
		super(Pessoa.class);
	}
	
	
}
