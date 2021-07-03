package dao;


import org.junit.Test;

import model.dao.GenericDao;
import model.dao.NivelPrioridadeDao;
import model.entity.NivelPrioridade;

public class NivelPrioridadeDaoTest {

	@Test
	public void testCreate() {
		NivelPrioridade nivelPrioridade = new NivelPrioridade();
		//baixo, médio, alto
		nivelPrioridade.setDescricao("baixo");
		
		GenericDao<NivelPrioridade> nivelPrioridadeDao = new NivelPrioridadeDao();
		nivelPrioridade = nivelPrioridadeDao.create(nivelPrioridade);	
		
		System.out.println(nivelPrioridade);
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
