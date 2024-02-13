package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.entity.UserInfo;

public class LoginDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public UserInfo giveLogin(String email, String password) {
		Query query = manager.createQuery("select u from UserInfo u where u.email=?1 and u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<UserInfo> users = query.getResultList();
		if (users != null && users.isEmpty() == false) {
			UserInfo user = users.get(0);
			return user;
		}
		return null;
	}
	public List<UserInfo> getAllUsers() {
		String role="Employee";
		Query query=manager.createQuery("select u from UserInfo u where u.role=?1");
		query.setParameter(1, role);
		List<UserInfo> users = query.getResultList();

		if(users.isEmpty()) {
			System.out.println("Empty");
		}
		
		
		return users;
		
	}

}
