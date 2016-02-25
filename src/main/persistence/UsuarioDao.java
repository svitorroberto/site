package persistence;

import model.Usuario;

public class UsuarioDao extends GenericDAOImpl<Usuario, Long> {
	@Override
	public void salvar(Usuario usuario) {
		em.persist(usuario);
	}
}
