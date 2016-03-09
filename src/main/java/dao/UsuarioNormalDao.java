package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

import org.hibernate.Criteria;
import org.hibernate.Session;

import util.HibernateUtil;

public class UsuarioNormalDao implements UsuarioDao {

	
  //Com entityManager	
	protected EntityManager entityManager;
	 
    public UsuarioNormalDao() {
        entityManager = getEntityManager();
    }
	
	private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios-persistence");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
 
        return entityManager;
    }
	
	public Usuario buscaUsuario(Long matricula) {
        return entityManager.find(Usuario.class, matricula);
    }
	
	@SuppressWarnings("unchecked")
    public List<Usuario> listar() {
        return entityManager.createQuery("from Usuario").getResultList();
    }
	public void inserir(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
	public void alterar(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
	public void excluir(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            usuario = entityManager.find(Usuario.class, usuario.getMatricula());
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
	public void removeById(final Long id) {
        try {
            Usuario usuario = buscaUsuario(id);
            excluir(usuario);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	//Final EntityManager
	

}
