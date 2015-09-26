package br.springdesktop.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Contexto da aplica��o
 * 
 * @author Fernando Godo�
 *
 */

@Configuration
@ComponentScan(basePackages = "br.springdesktop.*")
@EnableAspectJAutoProxy
public class Context {

}
