package br.edu.utfpr.model.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import br.edu.utfpr.model.Role;

public class MysqlRoleDAO extends MysqlDatabase implements RoleDAO {
	
	public MysqlRoleDAO() {
		
		openDB();
		
		try {
			
			stm.executeUpdate("CREATE TABLE IF NOT EXISTS matematica.roles "
					+ "(login VARCHAR(20) NOT NULL, role VARCHAR(20) NOT NULL, PRIMARY KEY(login, role));");
			
		}catch(SQLException e) {
			throw new RuntimeException("Erro ao criar tabela roles!" + e.getMessage());
		}finally {
			closeDB();
		}
	}

	@Override
	public void create(Role r) {
		
		openDB();
		
		try {
			
			PreparedStatement prepStm = (PreparedStatement) conn.prepareStatement("INSERT INTO roles VALUES (?,?)");
			
			prepStm.setString(1, r.getLogin());
			prepStm.setString(2, r.getRole());
			
			prepStm.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao criar Role!" + e.getMessage());
		}finally {
			closeDB();
		}
		
	}

	@Override
	public void delete(Role r) {
		
		openDB();
		
		try {
			stm.executeUpdate("DELETE FROM roles WHERE login = '" + r.getLogin() + "';");
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao remover Role!" + e.getMessage());
		}finally {
			closeDB();
		}
	}

	@Override
	public void update(Role r) {
		
	}

	@Override
	public List<Role> all() {
		
		openDB();
		
		List<Role> returnList = new ArrayList<Role>();
		
		try {
			ResultSet rs = stm.executeQuery("SELECT * FROM roles");
			
			while(rs.next()) {
				String login = rs.getString("login");
				String role = rs.getString("role");
				
				returnList.add(new Role(login, role));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao listar os Roles!" + e.getMessage());
		}finally {
			closeDB();
		}
		
		return returnList;
	}

	@Override
	public Role findByLogin(String buscaLogin) {
		
		Role returnRole = null;
		
		openDB();
		
		try {
			
			PreparedStatement prepStm = (PreparedStatement) conn.prepareStatement("SELECT * FROM roles WHERE login = ?");
			prepStm.setString(1, buscaLogin);
			
			ResultSet rs = prepStm.executeQuery();
			
			if(rs.next()) {
				String role = rs.getString("role");
				
				returnRole = new Role(buscaLogin, role);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar Role!" + e.getMessage());
		}finally {
			closeDB();
		}
		
		return returnRole;
	}

}
