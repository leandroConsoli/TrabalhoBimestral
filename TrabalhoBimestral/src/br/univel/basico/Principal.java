package br.univel.basico;

import java.sql.SQLException;

import br.univel.enums.EstadoCivil;

public class Principal {
	public static void main(String[] args) throws SQLException {
		new Principal();
	}

	public Principal() throws SQLException {

		Cliente c1 = new Cliente();
		c1.setId(2);
		c1.setNome("Sr Peidao");
		c1.setEndereco("Intestino Grosso");
		c1.setTelefone("(45) 9999-0000");
		c1.setEstadoCivil(EstadoCivil.SOLTEIRO);

		Cliente c2 = new Cliente();
		c2.setId(3);
		c2.setNome("Matei a Esposa");
		c2.setEndereco("sadasdadsdddddddddddd");
		c2.setTelefone("(45) 7485-1150");
		c2.setEstadoCivil(EstadoCivil.VIUVO);

		ConexaoFalse cf = new ConexaoFalse();

		DaoImpl d = new DaoImpl();

		try {
			d.setConexao(cf.abrirConexao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("apagarTabela\n");
		d.apagarTabela(c1);

		System.out.println("criarTabela\n");
		d.criarTabela(c1);

		System.out.println("inserir objeto 1\n");
		d.salvar(c1);

		System.out.println("inserir objeto 2\n");
		d.salvar(c2);

		System.out.println("listarTodos");
		for (Cliente c : d.listarTodos()) {
			System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getEndereco() + " - " + c.getTelefone()
					+ " - " + c.getEstadoCivil().toString());
		}

		System.out.println("\nbuscar objeto 1");
		Cliente c4 = new Cliente();
		c4 = d.buscar(c1.getId());
		System.out.println(c4.getId() + " - " + c4.getNome() + " - " + c4.getEndereco() + " - " + c4.getTelefone()
				+ " - " + c4.getEstadoCivil().toString());

		System.out.println("\nalterar objeto 2\n");
		c2.setEstadoCivil(EstadoCivil.CASADO);
		d.atualizar(c2);

		System.out.println("listarTodos");
		for (Cliente c : d.listarTodos()) {
			System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getEndereco() + " - " + c.getTelefone()
					+ " - " + c.getEstadoCivil().toString());
		}
		d.setConexao(null);
		cf.fecharConexao();

	}
}