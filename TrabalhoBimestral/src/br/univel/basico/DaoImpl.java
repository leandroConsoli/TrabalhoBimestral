package br.univel.basico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.enums.EstadoCivil;
import br.univel.interfaces.Dao;

public class DaoImpl implements Dao<Cliente, Integer> {
	private Connection con = null;
	
	
	public Connection getConexao(){
		return con;
	}
	
	public void setConexao(Connection con1){
		this.con = con1;
	}
	
	@Override
	public void salvar(Cliente t) {
		SqlExtends gera = new SqlExtends();
		try {
			PreparedStatement ps = gera.getSqlInsert(con, t);
			ps.setInt(1, t.getId());
			ps.setString(2, t.getNome());
			ps.setString(3, t.getEndereco());
			ps.setString(4, t.getTelefone());
			// Ordinal = transforma enum em int
			System.out.println(t.getEstadoCivil());
			ps.setInt(5, ((Enum<EstadoCivil>) t.getEstadoCivil()).ordinal());

			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cliente buscar(Integer k) {
		Cliente c = new Cliente();
		SqlExtends gera = new SqlExtends();

		try {

			PreparedStatement ps = gera.getSqlSelectById(con, new Cliente());
			ps.setInt(1, k);
			ResultSet resultados = ps.executeQuery();

			while (resultados.next()) {
				c.setId(resultados.getInt("CLID"));
				c.setNome(resultados.getString("CLNOME"));
				c.setEndereco(resultados.getString("CLENDERECO"));
				c.setTelefone(resultados.getString("CLTELEFONE"));
				c.setEstadoCivil(EstadoCivil.getPorid(resultados.getInt("CLEstadoCivil")));
			}

			ps.close();
			resultados.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public void atualizar(Cliente t) {
		SqlExtends gera = new SqlExtends();
		try {

			PreparedStatement ps = gera.getSqlUpdateById(con, t);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getEndereco());
			ps.setString(3, t.getTelefone());
			ps.setInt(4, ((Enum<EstadoCivil>) t.getEstadoCivil()).ordinal());
			ps.setInt(5, t.getId());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@Override
	public void excluir(Integer k) {
		SqlExtends gera = new SqlExtends();
		try {

			PreparedStatement ps = gera.getSqlDeleteById(con, new Cliente());
			ps.setInt(1, k);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public List<Cliente> listarTodos() {
		SqlExtends gera = new SqlExtends();
		List<Cliente> listaCliente = new ArrayList<Cliente>();

		try {

			PreparedStatement ps = gera.getSqlSelectAll(con, new Cliente());
			ResultSet resultados = ps.executeQuery();

			while (resultados.next()) {

				Cliente c = new Cliente();
				c.setId(resultados.getInt("CLID"));
				c.setNome(resultados.getString("CLNOME"));
				c.setEndereco(resultados.getString("CLENDERECO"));
				c.setTelefone(resultados.getString("CLTELEFONE"));
				c.setEstadoCivil(EstadoCivil.getPorid(resultados.getInt("CLEstadoCivil")));

				listaCliente.add(c);
			}

			ps.close();
			resultados.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaCliente;
	}

	@Override
	public void criarTabela(Cliente t) {
		SqlExtends gera = new SqlExtends();
		try {
			String sql = gera.getCreateTable(con, t);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@Override
	public void apagarTabela(Cliente t) {
		SqlExtends gera = new SqlExtends();
		try {
			String sql = gera.getDropTable(con, t);	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}	

	}

	public void apagarTabela1(Cliente c1) {
		// TODO Auto-generated method stub
		
	}

}