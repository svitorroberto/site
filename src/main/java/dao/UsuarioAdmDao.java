package dao;

import java.util.List;

import model.Usuario;


public class UsuarioAdmDao implements UsuarioDao{

	public void incluir(Usuario usuario) {
		System.out.println("UsuarioAdmDao.incluir()");
		
	}

	public void excluir(int matricula) {
		System.out.println("UsuarioAdmDao.excluir()");
		
	}

	public void alterar(int matricula) {
		System.out.println("UsuarioAdmDao.alterar()");
		
	}

	public List<Usuario> listar() {
		System.out.println("UsuarioAdmDao.listar()");
		return null;
	}

}
