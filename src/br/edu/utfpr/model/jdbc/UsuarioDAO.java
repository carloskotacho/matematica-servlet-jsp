package br.edu.utfpr.model.jdbc;

import java.util.List;

import br.edu.utfpr.model.Usuario;

public interface UsuarioDAO {
	
	public void create(Usuario u);
	public void delete(Usuario u);
	public void update(Usuario u);
	public List<Usuario> all();
	public Usuario findByLogin(String buscaLogin);

}
