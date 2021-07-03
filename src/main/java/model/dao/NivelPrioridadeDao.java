package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.db.DbUtil;
import model.entity.NivelPrioridade;

public class NivelPrioridadeDao implements GenericDao<NivelPrioridade> {

	EntityManager entityManager = DbUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public NivelPrioridade create(NivelPrioridade nivelPrioridade) {
		entityManager.getTransaction().begin();
		nivelPrioridade = (NivelPrioridade) entityManager.merge(nivelPrioridade);
		entityManager.getTransaction().commit();
		return nivelPrioridade;
	}

	@Override
	public List<NivelPrioridade> findAll() {
		return entityManager.createQuery("from NivelPrioridade", NivelPrioridade.class).getResultList();
	}

	@Override
	public NivelPrioridade update(Long id, NivelPrioridade nivelPrioridade) {
		nivelPrioridade.setId(id.intValue());
		entityManager.getTransaction().begin();
		nivelPrioridade = (NivelPrioridade) entityManager.merge(nivelPrioridade);
		entityManager.getTransaction().commit();
		return nivelPrioridade;
	}

	@Override
	public void delete(Long id) {
		entityManager.getTransaction().begin();
		entityManager.remove(id);
		entityManager.getTransaction().commit();
	}

	@Override
	public NivelPrioridade findById(Long id) {
		return entityManager.find(NivelPrioridade.class, id);
	}
	
}
