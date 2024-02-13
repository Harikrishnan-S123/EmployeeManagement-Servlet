package com.ty.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.UserInfo;

public class RegisterDao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("vikas");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	public UserInfo createUser(String name,String email,String password,String role,String designation,double salary) {
		UserInfo user=new UserInfo();
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		user.setDesignation(designation);
		user.setName(name);
		user.setSalary(salary);
		transaction.begin();
		manager.persist(user);
		transaction.commit();
		return user;
		
	}
	

}
