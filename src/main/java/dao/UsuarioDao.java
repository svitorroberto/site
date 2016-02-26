package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDao {
	
	public void incluir(Usuario usuario); 
	public List<Usuario> listar();

}
