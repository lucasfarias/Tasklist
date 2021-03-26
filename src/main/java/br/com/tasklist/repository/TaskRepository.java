package br.com.tasklist.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.tasklist.model.Task;

@Stateless
public class TaskRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Task> loadTasks(){
		return this.em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
	}
	
	public void deleteTask(Task task) {
		if(em.contains(task)) {
			em.remove(task);
		}else {
			Task managedTask = em.find(Task.class, task.getTaskId());
			if(managedTask != null) {
				em.remove(managedTask);
			}
		}
	}
	
	public void addTask(String titulo, String descricao) {
		Task novaTask = new Task(titulo, descricao);
		
		this.em.persist(novaTask);
	}
	
	public void updateTasks(List<Task> tasks) {
		tasks.forEach(em::merge);
	}

}
