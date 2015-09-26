package br.springdesktop.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Exemplo criado para armazenamento de objetos em lista
 *
 * @author Fernando Godóy
 *
 * @param <T>
 */
public abstract class GenericDao<T extends Serializable>  {

	private Map<String, List<T>> base = new HashMap<String, List<T>>();
	private  Class<T> clazz;
	
	public GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T getByObject(T clazz) throws Exception {
		String clazzName = clazz.getClass().getSimpleName();
		List<T> lista = base.get(clazzName);
		for (T objeto : lista) {
			if(objeto.equals(clazz)){
				return objeto;
			}
		}
		throw new Exception();
	}

	public List<T> findAll() {
		String clazzName = clazz.getClass().getSimpleName();
		List<T> lista = base.get(clazzName);
		return lista;
	}

	public void salvar(T clazz) {
		List<T> lista;
		String clazzName = getSimpleName(clazz);
		lista = base.get(clazzName);
		if(lista == null){
			lista = new ArrayList<T>();
		}
		lista.add(clazz);
		base.put(clazzName, lista);
	}

	private String getSimpleName(T clazz) {
		return clazz.getClass().getSimpleName();
	}

	public void excluir(T clazz) {
		String clazzName = getSimpleName(clazz);
		List<T> lista = base.get(clazzName);
		lista.remove(clazz);
		base.put(clazzName, lista);
	}

	public void escreverQuantidadeDeItensPorLista() {
		Set<String> keys = base.keySet();
		for (String key : keys) {
			List<T> list = base.get(key);
			System.out.println("Objeto: " + key + " - "
					+ "Tamanho atual da lista [ "  + list.size() + " ] \n");
		}
	}
}
