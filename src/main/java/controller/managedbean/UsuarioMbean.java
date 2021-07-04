package controller.managedbean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import exception.ErroAoApagarException;
import exception.ErroAoSalvarException;
import model.dao.GenericDao;
import model.dao.UsuarioDao;
import model.entity.NivelPrioridade;
import model.entity.Usuario;

@ManagedBean
public class UsuarioMbean {

	private Usuario usuario;
	
	private String dataNascimento;
	
	private List<String> mensagensErro;
	
	GenericDao<Usuario> usuarioDao;
	
	public UsuarioMbean() {
		usuario = new Usuario();
		mensagensErro = new ArrayList<String>();
		dataNascimento = null;
		usuarioDao = new UsuarioDao();
	}
	
	public void cadastrar() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		if(usuario.getNome() == null) {
			mensagensErro.add("O nome não pode estar vazio");
		}
		
		if(usuario.getCpf() == null) {
			mensagensErro.add("O CPF não pode estar vazio");
		}
		
		if(dataNascimento != null) {
			try {
				usuario.setDataNascimento(sdf.parse(dataNascimento));
			} catch (ParseException e) {
				mensagensErro.add("Formato de data inválido");
			}
		}
		
		if(!(mensagensErro.size()>0)) {
			try {
				usuarioDao.create(usuario);
			} catch (ErroAoSalvarException e) {
				mensagensErro.add("Erro ao cadastrar, verifique os dados inseridos");
			}
		}
	}
	
	public void apagar(long id) {
		try {
			usuarioDao.delete(id);
		} catch (ErroAoApagarException e) {
			mensagensErro.add("Ocorreu um erro ao apagar");
		}
	}

	public List<Usuario> getListaUsuarios() {
		return usuarioDao.findAll();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public List<String> getMensagensErro() {
		return mensagensErro;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
