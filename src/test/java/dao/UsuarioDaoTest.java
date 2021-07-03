package dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import model.dao.GenericDao;
import model.dao.UsuarioDao;
import model.entity.Usuario;

public class UsuarioDaoTest {

	@Test
	public void testCreate() {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = null;
		
//		try {
//			simpleDateFormat.parse("02-04-1990");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		Usuario usuario = new Usuario();
		
		usuario.setCpf("99999999999");
		usuario.setDataNascimento(date);
		usuario.setNome("Fulano");
		usuario.setSobrenome("Cicrano");
		
		GenericDao<Usuario> usuarioDao = new UsuarioDao();
		usuario = usuarioDao.create(usuario);	
		
		System.out.println(usuario);
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
