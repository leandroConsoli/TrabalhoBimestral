package br.univel.basico;

import br.univel.anotacoes.Coluna;
import br.univel.anotacoes.Tabela;
import br.univel.enums.EstadoCivil;

@Tabela("CAD_CLIENTE")
public class Cliente {
	
	@Coluna(pkey=true, nome="CLID", tamanho = 0)
	private int id;
	@Coluna(nome="CLNOME",tamanho = 90, pkey = false)
	private String nome;
	
	@Coluna(nome="CLENDERECO", tamanho = 150, pkey = false)
	private String endereco;
	
	@Coluna(nome="CLTELEFONE", tamanho = 15, pkey = false)
	private String telefone;
	
	@Coluna(nome="CLEstadoCivil", pkey = false, tamanho = 0)
	EstadoCivil estadoCivil;
	
				
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(Object object) {
		this.estadoCivil = (EstadoCivil) object;
	}




}