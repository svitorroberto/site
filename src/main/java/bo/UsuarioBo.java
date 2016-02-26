package bo;

import java.util.List;

import model.Usuario;
import dao.UsuarioDao;
import fabrica.FabricaDeUsuarioDao;

public class UsuarioBo {
	  
	  UsuarioDao usuarioDao;
	  
	  public UsuarioBo(String tipoDeUsuario) {
		  usuarioDao = FabricaDeUsuarioDao.novo(tipoDeUsuario);
		  }

		  public void incluir(Usuario usuario) {
		    if (!usuario.getMatricula().equals("")) {
		      usuarioDao.incluir(usuario);
		    }
		  }

		  public List<Usuario> listar() {
		    return usuarioDao.listar();
		  }
}
