package br.edu.utfpr.model;

import java.util.List;

import br.edu.utfpr.model.jdbc.MysqlUsuarioDAO;
import br.edu.utfpr.model.jdbc.UsuarioDAO;

public class Usuario {
	
	private static UsuarioDAO dao = new MysqlUsuarioDAO();
	
	private String login;
	private String pwd;
	
	public Usuario(String login, String pwd) {
		super();
		this.login = login;
		this.pwd = pwd;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	
	public static Usuario findByLogin(String buscaLogin) {
		return dao.findByLogin(buscaLogin);
	}
	
	public static List<Usuario> all(){
		return dao.all();
	}
	
}
