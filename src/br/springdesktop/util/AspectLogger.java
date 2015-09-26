package br.springdesktop.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.springdesktop.dao.PessoaDao;

/**
 * Exemplo de criação de Log utilizando AOP
 * 
 * @author Fernando Godoy
 *
 */
@Aspect
@Component
public class AspectLogger {

	@Autowired
	private PessoaDao dao;

	@Before("execution(* br.springdesktop.dao.GenericDao.salvar(..))")
	public void logInsertAntes(JoinPoint joinPoint) throws Throwable {
		System.out.println("Nova pessoa sendo cadastrada: [ " + joinPoint.getArgs()[0] + " ]");
	}

	@After("execution(* br.springdesktop.dao.GenericDao.salvar(..))")
	public void logInsert(JoinPoint joinPoint) throws Throwable {
		dao.escreverQuantidadeDeItensPorLista();
	}

	@Before("execution(* br.springdesktop.dao.GenericDao.excluir(..))")
	public void logRemoveAntes(JoinPoint joinPoint) throws Throwable {
		System.out.println("Item sendo removido: [ " + joinPoint.getArgs()[0] + " ]");
	}

	@After("execution(*  br.springdesktop.dao.GenericDao.excluir(..))")
	public void logRemove(JoinPoint joinPoint) throws Throwable {
		dao.escreverQuantidadeDeItensPorLista();
	}

}
