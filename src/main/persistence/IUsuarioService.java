package persistence;

import model.Usuario;

public interface IUsuarioService {
	public void salvar(Usuario usuario);
	public void listar();
	public void alterar();
	public void excluir();
}
