package controller.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import exception.ErroAoApagarException;
import exception.ErroAoSalvarException;
import model.dao.GenericDao;
import model.dao.NivelPrioridadeDao;
import model.entity.NivelPrioridade;

@ManagedBean
public class NivelPrioridadeMbean {

	private NivelPrioridade nivelPrioridade;

	private List<String> mensagensErro;

	GenericDao<NivelPrioridade> nivelPrioridadeDao;

	public NivelPrioridadeMbean() {
		nivelPrioridade = new NivelPrioridade();
		mensagensErro = new ArrayList<String>();
		nivelPrioridadeDao = new NivelPrioridadeDao();
	}

	public void cadastrar() {
		if (nivelPrioridade.getDescricao() == null) {
			mensagensErro.add("A descrição não pode estar vazia");
		}
		
		if(!(mensagensErro.size()>0)) {
			try {
				nivelPrioridadeDao.create(nivelPrioridade);
			} catch (ErroAoSalvarException e) {
				mensagensErro.add("Erro ao cadastrar, verifique os dados inseridos");
			}
		}
	}

	public void apagar(long id) {
		try {
			nivelPrioridadeDao.delete(id);
		} catch (ErroAoApagarException e) {
			mensagensErro.add("Ocorreu um erro ao apagar");
		}
	}

	public List<NivelPrioridade> getListaNiveis() {
		return nivelPrioridadeDao.findAll();
	}

	public NivelPrioridade getNivelPrioridade() {
		return nivelPrioridade;
	}

	public List<String> getMensagensErro() {
		return mensagensErro;
	}

}
