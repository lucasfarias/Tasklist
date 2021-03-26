package br.com.tasklist.view;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.tasklist.model.Task;
import br.com.tasklist.repository.TaskRepository;

@Named 
@ViewScoped
public class TarefaBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3857313289421572569L;
	
	private String titulo;
    private String descricao;
    
    private List<Task> tasks;
    
    @Inject
    private TaskRepository taskRepository;
    
    
    @PostConstruct
    public void init() {
    	this.tasks = taskRepository.loadTasks();
    }
    

	public String submit() {
        taskRepository.addTask(titulo, descricao);
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
		atualizarTasks();
		return "";
	}
	
	public String deletar(Task task) {
		taskRepository.deleteTask(task);
		return "";
	}
	
	public String atualizarTasks() {
		taskRepository.updateTasks(this.tasks);
		return "";
	}
	
	
}