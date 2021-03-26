package br.com.tasklist.view;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.tasklist.model.Task;
import java.io.Serializable;
import java.time.LocalDateTime;

@Named @SessionScoped
public class TarefaBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3857313289421572569L;
	
	private String titulo;
    private String descricao;
    
    private List<Task> tasks;
    
    

    public TarefaBean() {
		tasks = new ArrayList<Task>();
	}

	public String submit() {
        Task taskNova = new Task(titulo, descricao);
        tasks.add(taskNova);
        this.titulo = "";
        this.descricao = "";
        return "";
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

	public List<Task> getTasks() {
        return tasks;
    }
	
	public String concluir(Task task) {
		if(task.isConcluido()) {
			task.setDataConclusao(null);
			task.setConcluido(false);
		}else {
			task.setDataConclusao(LocalDateTime.now());
			task.setConcluido(true);
		}
		return "";
	}
	
	public String deletar(Task task) {
		tasks.remove(task);
		return "";
	}
	
	
}