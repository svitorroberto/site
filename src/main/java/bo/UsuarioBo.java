package bo;

import java.util.List;

import dao.UsuarioDao;

public class UsuarioBo {
	  
	  UsuarioDao usuarioDao;
	  
	  public UsuarioBo() {
	    
	  }

	  public void incluir(Aluno aluno) {
	    if (!aluno.getMatricula().equals("")) {
	      alunoDao.incluir(aluno);
	    }
	  }

	  public List<Aluno> listar() {
	    return alunoDao.listar();
	  }

	}
}
