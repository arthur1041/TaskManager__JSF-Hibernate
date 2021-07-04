package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import exception.ErroAoApagarException;
import exception.ErroAoSalvarException;
import exception.NullValueException;
import model.db.DbUtil;
import model.entity.NivelPrioridade;

public class NivelPrioridadeDao implements GenericDao<NivelPrioridade> {

	EntityManager entityManager = DbUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public NivelPrioridade create(NivelPrioridade nivelPrioridade) {
		
		if(nivelPrioridade.getDescricao() == null) {
			throw new NullValueException(" descrição ");
		}
		
		entityManager.getTransaction().begin();
		try {
			nivelPrioridade = (NivelPrioridade) entityManager.merge(nivelPrioridade);
		} catch (PersistenceException e) {
			throw new ErroAoSalvarException();
		}
		entityManager.getTransaction().commit();
		return nivelPrioridade;
	}

	@Override
	public List<NivelPrioridade> findAll() {
		return entityManager.createQuery("from NivelPrioridade", NivelPrioridade.class).getResultList();
	}

	@Override
	public NivelPrioridade update(Long id, NivelPrioridade nivelPrioridade) {
		NivelPrioridade nivelPrioridadeAtual = findById(id);
		
		if(nivelPrioridadeAtual == null) {
			return null;
		}
		
		if(nivelPrioridade.getDescricao() == null) {
			nivelPrioridadeAtual.setDescricao(nivelPrioridade.getDescricao());
		} 
		
		entityManager.getTransaction().begin();
		nivelPrioridade = (NivelPrioridade) entityManager.merge(nivelPrioridadeAtual);
		entityManager.getTransaction().commit();
		return nivelPrioridade;
	}

	@Override
	public void delete(Long id) {
		NivelPrioridade nivelPrioridade = new NivelPrioridade();
		nivelPrioridade.setId(id.intValue());
		
		entityManager.getTransaction().begin();
		
		if(!entityManager.contains(nivelPrioridade))
			nivelPrioridade = entityManager.merge(nivelPrioridade);
		try {
			entityManager.remove(nivelPrioridade);
		} catch (PersistenceException e) {
			throw new ErroAoApagarException();
		}
		entityManager.getTransaction().commit();
	}

	@Override
	public NivelPrioridade findById(Long id) {
		return entityManager.find(NivelPrioridade.class, id.intValue());
	}
	
}
