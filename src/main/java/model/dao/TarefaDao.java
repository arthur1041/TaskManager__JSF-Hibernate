package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.db.DbUtil;
import model.entity.Tarefa;

public class TarefaDao implements GenericDao<Tarefa> {

	EntityManager entityManager = DbUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public Tarefa create(Tarefa tarefa) {
		entityManager.getTransaction().begin();
		tarefa = (Tarefa) entityManager.merge(tarefa);
		entityManager.getTransaction().commit();
		return tarefa;
	}

	@Override
	public List<Tarefa> findAll() {
		return entityManager.createQuery("from Tarefa", Tarefa.class).getResultList();
	}

	@Override
	public Tarefa update(Long id, Tarefa tarefa) {
		tarefa.setId(id);
		entityManager.getTransaction().begin();
		tarefa = (Tarefa) entityManager.merge(tarefa);
		entityManager.getTransaction().commit();
		return tarefa;
	}

	@Override
	public void delete(Long id) {
		entityManager.getTransaction().begin();
		entityManager.remove(id);
		entityManager.getTransaction().commit();
	}

	@Override
	public Tarefa findById(Long id) {
		return entityManager.find(Tarefa.class, id);
	}

}
