package dao;


import org.junit.Test;

import model.dao.GenericDao;
import model.dao.NivelPrioridadeDao;
import model.dao.TarefaDao;
import model.dao.UsuarioDao;
import model.entity.NivelPrioridade;
import model.entity.Tarefa;
import model.entity.Usuario;

public class TarefaDaoTest {

	@Test
	public void testCreate() {
		Tarefa tarefa = new Tarefa();

		GenericDao<Tarefa> tarefaDao = new TarefaDao();
		
		Usuario usuario = new UsuarioDao().findById(1l);
		
		NivelPrioridade nivelPrioridade = new NivelPrioridadeDao().findById(1l);
		
		tarefa = tarefaDao.create(tarefa);	
		
		System.out.println(tarefa);
	}

//	@Test
	public void testFindAll() {
		
	}
	
//	@Test
	public void testUpdate() {
		
	}
	
//	@Test
	public void testDelete() {
		
	}
	
//	@Test
	public void testFindById() {
		
	}
}
