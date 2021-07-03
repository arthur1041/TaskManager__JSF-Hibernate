package model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Tarefa implements Serializable{

	private static final long serialVersionUID = 1L;

	public Tarefa() {
		
	}
	
	public Tarefa(Long id, String titulo) {
		this.id = id;
	}
	
	@Id
	@Column(name = "idTask")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String titulo;
	
	@Column(nullable = false)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;
	
	@OneToOne
	private NivelPrioridade nivelPrioridade;
	
	@Column
	private Date deadline;
	
	@Column
	private Date dataCadastro;
	
	@Column
	private Date dataModicicacao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public NivelPrioridade getNivelPrioridade() {
		return nivelPrioridade;
	}

	public void setNivelPrioridade(NivelPrioridade nivelPrioridade) {
		this.nivelPrioridade = nivelPrioridade;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataModicicacao() {
		return dataModicicacao;
	}

	public void setDataModicicacao(Date dataModicicacao) {
		this.dataModicicacao = dataModicicacao;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(id, other.id);
	}

	
	 
}
