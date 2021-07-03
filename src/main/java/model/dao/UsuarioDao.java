package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.db.DbUtil;
import model.entity.Usuario;

public class UsuarioDao implements GenericDao<Usuario> {

	EntityManager entityManager = DbUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public Usuario create(Usuario usuario) {
		entityManager.getTransaction().begin();
		usuario = (Usuario) entityManager.merge(usuario);
		entityManager.getTransaction().commit();
		return usuario;
	}

	@Override
	public List<Usuario> findAll() {
		return entityManager.createQuery("from Usuario", Usuario.class).getResultList();
	}

	@Override
	public Usuario update(Long id, Usuario usuario) {
		usuario.setId(id);
		entityManager.getTransaction().begin();
		usuario = (Usuario) entityManager.merge(usuario);
		entityManager.getTransaction().commit();
		return usuario;
	}

	@Override
	public void delete(Long id) {
		entityManager.getTransaction().begin();
		entityManager.remove(id);
		entityManager.getTransaction().commit();
	}

	@Override
	public Usuario findById(Long id) {
		return entityManager.find(Usuario.class, id);
	}

}
