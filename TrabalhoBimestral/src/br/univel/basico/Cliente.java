package br.univel.basico;

import br.univel.anotacoes.Coluna;
import br.univel.anotacoes.Tabela;

@Tabela("CAD_CLIENTE")
public class Cliente {

	@Coluna(pk=true)
	private int id;

	@Coluna(nome="CLNOME")
	private String nome;

	public Cliente() {
		this(0, null);
	}

	public Cliente(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}


	public void dizerOla() {
		System.out.println("Olá!");
	}

	public String retornarOla(String nome) {
		return "Olá " + nome + "!";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + "]";
	}

}
