package fabrica;

import model.Usuario;
import dao.UsuarioDao;


public class FabricaDeUsuarioDao {
	
	public static UsuarioDao novo() {
		return new UsuarioDao();
	}
	
}

