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
		Usuario usuarioAtual = findById(id);
		
		if(usuarioAtual == null) {
			return null;
		}
		
		if(usuario.getCpf() != null)
			usuario.setCpf(usuario.getCpf());
		
		if(usuario.getDataNascimento() != null) {
			usuarioAtual.setDataNascimento(usuario.getDataNascimento());
		}
		
		if(usuario.getNome() != null) {
			usuarioAtual.setNome(usuario.getNome());
		}
		
		if(usuario.getSobrenome() != null) {
			usuarioAtual.setSobrenome(usuario.getSobrenome());
		}
		
		entityManager.getTransaction().begin();
		usuario = (Usuario) entityManager.merge(usuarioAtual);
		entityManager.getTransaction().commit();
		return usuario;
	}

	@Override
	public void delete(Long id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		
		entityManager.getTransaction().begin();

		if(!entityManager.contains(usuario))
			usuario = entityManager.merge(usuario);
		
		entityManager.remove(usuario);
		entityManager.getTransaction().commit();
	}

	@Override
	public Usuario findById(Long id) {
		return entityManager.find(Usuario.class, id);
	}

}
