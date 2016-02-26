package dao;

import java.util.List;

import model.Usuario;

public class UsuarioNormalDao implements UsuarioDao{

	public void incluir(Usuario usuario) {
		System.out.println("UsuarioNormalDao.incluir()");
		
	}

	public void excluir(int matricula) {
		System.out.println("UsuarioNormalDao.excluir()");
		
	}

	public void alterar(int matricula) {
		System.out.println("UsuarioNormalDao.alterar()");
		
	}

	public List<Usuario> listar() {
		System.out.println("UsuarioNormalDao.listar()");
		return null;
	}

}
