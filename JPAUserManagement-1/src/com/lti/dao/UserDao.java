package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.lti.model.Users;
import com.lti.utils.JpaUtils;


public class UserDao {
	private EntityManager entityManager;
	
	
	public UserDao() {
		entityManager = JpaUtils.getEntityManager();
	}
	
	public int readLogin(String username, String password){
		String jpql = "Select u from Users u where u.username='"+username+"' And u.password='"+password+"'";
		TypedQuery<Users> tquery = entityManager.createQuery(jpql, Users.class);
		List<Users> list = tquery.getResultList();
		
		return list.size();
		
	}
	
	
	public int createUser(Users user){
		entityManager.persist(user);
		return 1;
	}
	
	public List<Users> readAllUsers(){
		TypedQuery<Users> query = entityManager.createQuery("Select u From Users u", Users.class);
		List<Users> list = query.getResultList();
		return list;
	}
	
	public Users readUserByUsername(String username)
	{
		return entityManager.find(Users.class, username);
	}
	
	public Users updateUser(Users user) {
		
		return entityManager.merge(user);
	}
	
	public int deleteUser(String username){
		Users user = readUserByUsername(username);
		if(user != null){
			String query = "Delete u from Users u where u.username="+username;
			
			entityManager.remove(user);
			return 1;
		}
		return 0;
	}
	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}

	
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}


	public void rollbackTransaction() {
		entityManager.getTransaction().rollback();
		
	}

	
	
}


	
	
	
	
	
	
	


                                                                                                                     