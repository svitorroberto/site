package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import bo.UsuarioBo;

@WebServlet(value = "/bancodados/CadastrarAluno")
public class UsuarioCtrl {

	protected void service(
		      HttpServletRequest req,
		      HttpServletResponse resp)
		      throws ServletException, IOException {
		
		String paramLogin = req.getParameter("login");
	    String login = paramLogin == null ? "" : paramLogin;
	    
	    String paramNome = req.getParameter("nome");
	    String nome = paramNome == null ? "" : paramNome;
	    
	    String paramSenha = req.getParameter("senha");
	    String senha = paramSenha == null ? "" : paramSenha;
	    
	    String paramEmail = req.getParameter("email");
	    String email = paramEmail == null ? "" : paramEmail;
	    
	    String paramNasc = req.getParameter("nascimento");
	    String nasc = paramNasc == null ? "" : paramNasc;
	    
	    String paramPSecreta = req.getParameter("psecreta");
	    String pSecreta = paramPSecreta == null ? "" : paramPSecreta;
	    
	    String paramRSecreta = req.getParameter("rsecreta");
	    String rSecreta = paramRSecreta == null ? "" : paramRSecreta;
	    
	    String paramTel = req.getParameter("telefone");
	    String telefone = paramTel == null ? "" : paramTel;
	    
	    String paramTipo = req.getParameter("tipo");
	    String tipo = paramTipo == null ? "" : paramTipo;
	    
	    
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setNomeCompleto(nome);
		usuario.setSenha(senha);
		usuario.setEmail(email);
		usuario.setDataNasc(nasc);
		usuario.setPerguntaSecreta(pSecreta);
		usuario.setRespostaSecreta(rSecreta);
		usuario.setTelefone(telefone);
		usuario.setTipo(tipo);
		
		UsuarioBo ubo = new UsuarioBo(tipo);
		ubo.incluir(usuario);
		
		req.setAttribute("usuario", usuario); //Passando um objeto para o JSP.

	    List<Usuario> alunos = UsuarioBo.listar();

	    req.setAttribute("alunos", alunos); //Passando uma cole��o para o JSP.
	    
	    //Chamar o JSP apenas para mostrar o resultado.
	    req.getRequestDispatcher("CadastroAlunoView.jsp").forward(req, resp);
		
		
	
	}
}
