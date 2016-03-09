package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import model.Usuario;
import dao.UsuarioDao;
import dao.UsuarioNormalDao;

@ManagedBean(name="usuarioController")
@SessionScoped
public class UsuarioController implements Serializable{

	Usuario usuario = new Usuario();
	List<Usuario> usuarios = new ArrayList<Usuario>();

	
	/*public UsuarioController(){
		usuarios = new UsuarioNormalDao().listar();
		usuario = new Usuario();
	}*/
	
	
	public void limpar(){
		usuario.setDataNasc(null);
		usuario.setEmail(null);
		usuario.setLogin(null);
		usuario.setMatricula(null);
		usuario.setNomeCompleto(null);
		usuario.setPerguntaSecreta(null);
		usuario.setRespostaSecreta(null);
		usuario.setSenha(null);
		usuario.setTelefone(null);
		usuario.setTipo(null);
	}
	
	
	public String excluirUsuario(){
		new UsuarioNormalDao().excluir(usuario);
		listarUsuarios();
		usuario = new Usuario();
		return "matricula";
		
	}

	public String adicionarUsuario(){
		new UsuarioNormalDao().inserir(usuario);
		listarUsuarios();
		usuario = new Usuario();
		return "matricula";
		
	}
	
	public String alterarUsuario(){
		new UsuarioNormalDao().alterar(usuario);
		listarUsuarios();
		usuario = new Usuario();
		return "matricula";
	}
	
	public List<Usuario> listarUsuarios(){
		usuarios = new UsuarioNormalDao().listar();
		System.out.println(usuarios.toString());
		return usuarios;
	}
	
	//getters and setters
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List usuarios) {
		this.usuarios = usuarios;
	}
	
}
