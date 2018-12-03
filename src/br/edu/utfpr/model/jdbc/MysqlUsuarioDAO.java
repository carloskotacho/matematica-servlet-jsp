package br.edu.utfpr.model.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import br.edu.utfpr.model.Usuario;

public class MysqlUsuarioDAO extends MysqlDatabase implements UsuarioDAO {
	
	public MysqlUsuarioDAO() {
		
		openDB();
		
		try {
			
			stm.executeUpdate("CREATE TABLE IF NOT EXISTS matematica.usuarios "
					+ "(login VARCHAR(64) NOT NULL PRIMARY KEY, pwd	VARCHAR(64) NOT NULL);");
			
		}catch(SQLException e) {
			throw new RuntimeException("Erro ao criar tabelas de usuarios!" + e.getMessage());
		}finally {
			closeDB();
		}
	}

	@Override
	public void create(Usuario u) {
		
		openDB();
		
		try {
			
			PreparedStatement prepStm = (PreparedStatement) conn.prepareStatement("INSERT INTO usuarios VALUES (?,?)");
			
			prepStm.setString(1, u.getLogin());
			prepStm.setString(2, u.getPwd());
			
			prepStm.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao criar Usuário!" + e.getMessage());
		}finally {
			closeDB();
		}
		
	}

	@Override
	public void delete(Usuario u) {
		
		openDB();
		
		try {
			stm.executeUpdate("DELETE FROM usuarios WHERE login = '" + u.getLogin() + "';");
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao remover Usuário!" + e.getMessage());
		}finally {
			closeDB();
		}
	}

	@Override
	public void update(Usuario u) {
		
	}

	@Override
	public List<Usuario> all() {
		
		openDB();
		
		List<Usuario> returnList = new ArrayList<Usuario>();
		
		try {
			ResultSet rs = stm.executeQuery("SELECT * FROM usuarios");
			
			while(rs.next()) {
				String login = rs.getString("login");
				String pwd = rs.getString("pwd");
				
				returnList.add(new Usuario(login, pwd));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao listar os Usuários!" + e.getMessage());
		}finally {
			closeDB();
		}
		
		return returnList;
	}

	@Override
	public Usuario findByLogin(String buscaLogin) {
		
		Usuario returnUsuario = null;
		
		openDB();
		
		try {
			
			PreparedStatement prepStm = (PreparedStatement) conn.prepareStatement("SELECT * FROM usuarios WHERE login = ?");
			prepStm.setString(1, buscaLogin);
			
			ResultSet rs = prepStm.executeQuery();
			
			if(rs.next()) {
				String pwd = rs.getString("pwd");
				
				returnUsuario = new Usuario(buscaLogin, pwd);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar Usuário!" + e.getMessage());
		}finally {
			closeDB();
		}
		
		return returnUsuario;
	}

}
