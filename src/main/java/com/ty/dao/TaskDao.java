package com.ty.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.entity.Task;
import com.ty.entity.UserInfo;

public class TaskDao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("vikas");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	public Task assignTask(String id,String description) {
		int userdId=Integer.parseInt(id);
//		Task task=null;
		UserInfo user=manager.find(UserInfo.class, userdId);
		List<Task> tasks=user.getTasks();
		Task task=new Task();
		task.setUser(user);
		task.setDescription(description);
		task.setStatus("Open");
		if(tasks==null) {
			tasks=new ArrayList<Task>();
			
		}
		tasks.add(task);
		user.setTasks(tasks);
		transaction.begin();
		manager.merge(user);
		manager.persist(task);
		transaction.commit();
		
		return task;
		
		
	}
	public Task updateTask(String id) {
		
		int taskId=Integer.parseInt(id);
		Task task=manager.find(Task.class, taskId);
		task.setStatus("completed");
		if(task!=null) {
			transaction.begin();
			manager.merge(task);
			transaction.commit();
		}
		return task;
		
		
	}
	
	public List<Task> viewTasks(){
		Query query=manager.createQuery("select t from Task t order by status desc");
		List<Task> tasks=query.getResultList();
		return tasks;
		
	}
	public List<Task> viewPendingTasks(int id){
		Query query=manager.createQuery("select t from Task t where status=?1");
		query.setParameter(1, "Open");
		List<Task> tasks=query.getResultList();
		List<Task> pendingTasks=new ArrayList<Task>();
		for(Task task:tasks) {
			if(task.getUser().getId()==id) {
				pendingTasks.add(task);
			}
		}
		return pendingTasks;
		
	}
	
	public List<Task> viewAllTasksUser(int id){
		Query query=manager.createQuery("select t from Task t");
		List<Task> tasks=query.getResultList();
		Collections.sort(tasks,new Comparator<Task>() {
			@Override
			public int compare(Task t1, Task t2) {
				
				if(t1.getStatus().equalsIgnoreCase("open"))
					return -1;
				else
					return 1;
				
			}
			
		});
		List<Task> filter=new ArrayList<Task>();
		for(Task task:tasks) {
			if(task.getUser().getId()==id) {
				filter.add(task);
			}
		}
		
		return filter;
		
	}


}
