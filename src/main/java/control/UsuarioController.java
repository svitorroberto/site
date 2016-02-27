package control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import model.Usuario;
import dao.UsuarioDao;
import dao.UsuarioNormalDao;

@ManagedBean
@SessionScoped
public class UsuarioController {

	private Usuario usuario;
	private DataModel usuarios;
	
	public DataModel getListarUsuarios() {
		List<Usuario> lista = new UsuarioNormalDao().listar();
		usuarios = new ListDataModel(lista);
		return usuarios;
		}
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String adicionarUsuario(){
		UsuarioDao dao = new UsuarioNormalDao();
		dao.incluir(usuario);
		return "matricula";
	}
}
