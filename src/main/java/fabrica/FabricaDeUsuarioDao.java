package fabrica;

import dao.UsuarioAdmDao;
import dao.UsuarioDao;
import dao.UsuarioNormalDao;


public class FabricaDeUsuarioDao {
	
	public static UsuarioDao novo(String tipoDeAluno) {
	    if (tipoDeAluno.equals("ead")) {
	      return new UsuarioAdmDao();
	    } else  {
	      return new UsuarioNormalDao();
	    } 
	  }
	
}

