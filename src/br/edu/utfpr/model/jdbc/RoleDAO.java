package br.edu.utfpr.model.jdbc;

import java.util.List;

import br.edu.utfpr.model.Role;

public interface RoleDAO {

	public void create(Role r);
	public void delete(Role r);
	public void update(Role r);
	public List<Role> all();
	public Role findByLogin(String buscaLogin);
	
}
