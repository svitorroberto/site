package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDao {
	
	public void incluir(Usuario usuario);
	public void excluir(int matricula);
	public void alterar(int matricula);
	public List<Usuario> listar();

}
