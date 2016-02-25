package persistence;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

public abstract class GenericDAOImpl<E, ID extends Serializable> implements GenericDAO<E, ID> {

	private  Class<E> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(){
		this.classe = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@PersistenceContext (type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public Class<E> getClasse() {
		return this.classe;
	}

	public void commitManual(){		
		em.getTransaction().commit();		
	}
	
	public void beginTranscation(){
		em.getTransaction().begin();
	}
	
	public void salvar(E entidade) {
		em.persist(entidade);
	}
	
	public void alterar(E entidade) {
		em.merge(entidade);

	}

	public void remover(E entidade){
		//Quando objeto está na transação 
		em.remove(entidade);
	}
	
	public void remover(E entidade, Long id){
		//Quando tiver o risco da tranasação ter finalizado - em teste
		em.remove(em.getReference(entidade.getClass(), id));
	}

	public E buscarPorId(ID id) {
		E entidade = em.find(classe, id);
		return entidade;
	}
	
	public void refresh(E entidade){
		em.refresh(entidade);
	}

	@SuppressWarnings("unchecked")
	public List<E> buscarTodos() {
		
		List<Long> lista = em.createQuery("select o.id from "+ classe.getSimpleName() + " o").getResultList();
		List<E> listaTemp = new ArrayList<>();
		
		String str = "";
		for (Long e : lista) {			
			str += e.toString() + ", ";
		}
		
		if(!str.equals("") && str.length() >= 3){
			
			str = "("+ str.substring(0, str.length()-2) + ")";
			
			listaTemp = em.createQuery("select o from "+ classe.getSimpleName() + " o WHERE o.id IN " + str).getResultList(); 
		} else {
			listaTemp = em.createQuery("select o from "+ classe.getSimpleName()  + " o ").getResultList();
		}
		
		return listaTemp;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> executarSelect(String string){
		Query q = em.createNativeQuery(string);
		List<Object[]> lista = q.getResultList();	
		return lista;
	}
	
	public void detach(E entidade){
		em.detach(entidade);
	}
	
	public void limpar(E entidade){
		/*em.flush();*/
		em.clear();
	}
	
	public int executarScprit(String string){
		Query q = em.createNativeQuery(string);
		return q.executeUpdate();	
	}
	
	public void flush(){
		em.flush();		
	}
	
	public Connection getConexao(){
		return ((SessionImpl) (em.getDelegate())).connection();
	}
	
	public void fecharSessaoJPA(){
		em.close();
	}
	
	public void rollback(){
		//TODO terminar
	}
}
