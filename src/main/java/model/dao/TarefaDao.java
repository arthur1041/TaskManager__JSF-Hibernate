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
		Tarefa tarefaAtual = findById(id);
		
		if(tarefaAtual == null) {
			return null;
		}
		
		if(tarefa.getDescricao() != null) {
			tarefaAtual.setDescricao(tarefa.getDescricao());
		}
		
		if(tarefa.getUsuario() != null) {
			tarefaAtual.setUsuario(tarefa.getUsuario());
		}
		
		if(tarefa.getDeadline() != null) {
			tarefaAtual.setDeadline(tarefa.getDeadline());
		}
		
		if(tarefa.getDataCadastro() != null) {
			tarefaAtual.setDataCadastro(tarefa.getDataCadastro());
		}
		
		if(tarefa.getDataModicicacao() != null) {
			tarefaAtual.setDataModicicacao(tarefa.getDataModicicacao());
		}
		
		if(tarefa.getNivelPrioridade() != null) {
			tarefaAtual.setNivelPrioridade(tarefa.getNivelPrioridade());
		}
		
		if(tarefa.getTitulo() != null) {
			tarefaAtual.setTitulo(tarefa.getTitulo());
		}
		
		entityManager.getTransaction().begin();
		
		tarefa = (Tarefa) entityManager.merge(tarefaAtual);
		
		entityManager.getTransaction().commit();
		
		return tarefa;
	}

	@Override
	public void delete(Long id) {
		Tarefa tarefa = new Tarefa();
		tarefa.setId(id);
		
		entityManager.getTransaction().begin();
		
		if(!entityManager.contains(tarefa))
			tarefa = entityManager.merge(tarefa);
		
		entityManager.remove(tarefa);
		entityManager.getTransaction().commit();
	}

	@Override
	public Tarefa findById(Long id) {
		return entityManager.find(Tarefa.class, id);
	}

}
