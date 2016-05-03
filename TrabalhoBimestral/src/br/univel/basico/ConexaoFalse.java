package br.univel.basico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFalse {
	Connection con = null;
	
	public Connection abrirConexao() throws SQLException{
		String url = "jdbc:h2:~/test";
		String user = "sa";
		String pass = "sa";
		con = DriverManager.getConnection(url, user, pass);
		return con;
	}
	public Connection fecharConexao(){
		return con;
	}
}