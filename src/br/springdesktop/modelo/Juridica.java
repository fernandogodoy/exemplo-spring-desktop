package br.springdesktop.modelo;

public class Juridica extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	
	Juridica(String nome, String senha, String cnpj) {
		this.nome = nome;
		this.senha = senha;
		this.cnpj = cnpj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Juridica other = (Juridica) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " CNPJ: " + this.cnpj ;
	}
	
}
