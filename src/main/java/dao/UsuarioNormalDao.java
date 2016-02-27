package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import model.Usuario;

import org.hibernate.Hibernate;
import org.hibernate.classic.Session;

public class UsuarioNormalDao implements UsuarioDao {

	public void createEmpresa(Usuario u) throws Exception {
		EntityManager em = null;
	    EntityManagerFactory emf = null;
	    
	    try {
	        //Obter uma fábrica de conexões com o banco de dados.
	        emf = Persistence.createEntityManagerFactory("alunos-persistence-unit");

	        //Obter conexão com o banco de dados.
	        em = emf.createEntityManager();

	        em.getTransaction().begin();

	        em.merge(u);

	        em.getTransaction().commit();
	      } catch (Exception e) {
	        e.printStackTrace();
	        if (em != null) {
	          em.getTransaction().rollback();
	        }
	      } finally {
	        if (em != null) {
	          em.close();
	        }
	        if (emf != null) {
	          emf.close();
	        }
	      }
	    
	    public List<Usuario> listar(){
	    	Session session = Hibernate.getSessionFactory().openSession();
	    	Transaction t = session.beginTransaction();
	    	List lista = session.createQuery("from Livro").list();
	    	t.commit();
	    	return lista;
	    	}
	    
	    
	}

	
	
	public void incluir(Usuario usuario) {
		System.out.println("UsuarioNormalDao.incluir()");

	}

	public void excluir(int matricula) {
		System.out.println("UsuarioNormalDao.excluir()");

	}

	public void alterar(int matricula) {
		System.out.println("UsuarioNormalDao.alterar()");

	}


}
