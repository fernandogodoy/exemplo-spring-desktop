package br.springdesktop.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.springdesktop.controller.ClienteController;
import br.springdesktop.dao.PessoaDao;
import br.springdesktop.modelo.Fisica;
import br.springdesktop.modelo.Pessoa;
import br.springdesktop.util.Context;

public class FisicaTest {

	ApplicationContext contexto;
	ClienteController controller;
	PessoaDao dao;

	@Before
	public void setUp() {
		contexto = new AnnotationConfigApplicationContext(Context.class);
		controller = contexto.getBean(ClienteController.class);
		dao = contexto.getBean(PessoaDao.class);
	}
	
	@After
	public void tearDown(){
		contexto = null;
		controller = null;
		dao = null;
	}

	@Test
	public void testAdd() throws Exception {
		Pessoa cliente = new Fisica("Jão", "123345", "123.456.789-12");
		controller.salvar(cliente);
		assertEquals(cliente, dao.getByObject(cliente));
	}

	@Test(expected= Exception.class)
	public void testRemove() throws Exception {
		Pessoa cliente = new Fisica("Pedro", "1233456", "231.465.798-12");
		controller.salvar(cliente);
		assertEquals(cliente, dao.getByObject(cliente));

		Pessoa c1 = new Fisica("Carlos", "123345", "321.654.987-12");
		controller.salvar(c1);
		assertEquals(c1, dao.getByObject(c1));
		
		dao.excluir(cliente);
		assertEquals(null, dao.getByObject(cliente));
	}

}
