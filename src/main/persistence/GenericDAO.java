package persistence;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

public interface GenericDAO<E, ID extends Serializable> {
	
	void salvar (E entidade);
	void alterar (E entidade);
	void remover (E entidade);
	void remover(E entidade, Long id);
	void refresh(E entidade);
	void limpar(E entidade);
	E buscarPorId (ID id);
	List<E> buscarTodos();
	public void detach(E entidade);
	public int executarScprit(String string);
	public Connection getConexao();
	void fecharSessaoJPA();
	List<Object[]> executarSelect(String string);
	public void flush();
	public void commitManual();
	public void beginTranscation();
}
