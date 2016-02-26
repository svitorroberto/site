package bo;

import java.util.List;

import model.Usuario;
import dao.UsuarioDao;
import fabrica.FabricaDeUsuarioDao;

public class UsuarioBo {
	  
	  static UsuarioDao usuarioDao;
	  
	  public UsuarioBo(String tipoDeUsuario) {
		  usuarioDao = FabricaDeUsuarioDao.novo(tipoDeUsuario);
		  }

		  public void incluir(Usuario usuario) {
		    if (!usuario.getMatricula().equals("")) {
		      usuarioDao.incluir(usuario);
		    }
		  }

		  public static List<Usuario> listar() {
		    return usuarioDao.listar();
		  }
}
