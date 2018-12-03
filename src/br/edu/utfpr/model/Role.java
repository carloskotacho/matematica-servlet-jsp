package br.edu.utfpr.model;

import java.util.List;

import br.edu.utfpr.model.jdbc.MysqlRoleDAO;
import br.edu.utfpr.model.jdbc.RoleDAO;

public class Role {
	
	private static RoleDAO dao = new MysqlRoleDAO();
	
	private String login;
	private String role;
	
	public Role(String login, String role) {
		super();
		this.login = login;
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	/** ========== CRUD ========== */
	
	public void save() {
		if(dao.findByLogin(login) != null)
			dao.update(this);
		else
			dao.create(this);
	}
	
	public void delete() {
		dao.delete(this);
	}
	
	public static Role findByLogin(String buscaLogin) {
		return dao.findByLogin(buscaLogin);
	}
	
	public static List<Role> all(){
		return dao.all();
	}
}
