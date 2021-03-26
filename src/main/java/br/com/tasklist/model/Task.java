package br.com.tasklist.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


public class Task {
	
	@Id
	@GeneratedValue
	@Column(name = "id_task")
	private int taskId;
	
	@Column(name="bl_concluido")
	private boolean concluido;
	
	@Column(name="st_titulo")
	private String titulo;
	
	@Column(name="st_descricao")
	private String descricao;
	
	@Column(name="dt_dataCriacao")
	private LocalDateTime dataCriacao;
	
	@Column(name="dt_dataEdicao")
	private LocalDateTime dataEdicao;
	
	@Column(name="dt_dataConclusao")
	private LocalDateTime dataConclusao;
	
	
	public Task() {
		super();
	}
	
	public Task(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.concluido = false;
		this.dataCriacao = LocalDateTime.now();
	}

	public Task(int taskId, boolean concluido, String titulo, String descricao, LocalDateTime dataCriacao, LocalDateTime dataEdicao,
			LocalDateTime dataConclusao) {
		super();
		this.taskId = taskId;
		this.concluido = concluido;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataEdicao = dataEdicao;
		this.dataConclusao = dataConclusao;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(LocalDateTime dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDateTime dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dataConclusao == null) ? 0 : dataConclusao.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataEdicao == null) ? 0 : dataEdicao.hashCode());
		result = prime * result + (concluido ? 1231 : 1237);
		result = prime * result + taskId;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dataConclusao == null) {
			if (other.dataConclusao != null)
				return false;
		} else if (!dataConclusao.equals(other.dataConclusao))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataEdicao == null) {
			if (other.dataEdicao != null)
				return false;
		} else if (!dataEdicao.equals(other.dataEdicao))
			return false;
		if (concluido != other.concluido)
			return false;
		if (taskId != other.taskId)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	

}
