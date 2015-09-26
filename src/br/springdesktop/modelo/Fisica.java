package br.springdesktop.modelo;

public class Fisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	Fisica(String nome, String senha, String cpf) {
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
	}
	
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fisica other = (Fisica) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}


	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " CPF: " + this.cpf ;
	}
	
	
	
	
}
