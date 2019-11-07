package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Users;
import com.lti.utils.JpaUtils;

public class UserDaoImpl implements UserDao {
private EntityManager entityManager;
	
	
	public UserDaoImpl() {
		entityManager = JpaUtils.getEntityManager();
	}


	@Override
	public int readLogin(String username, String password) {
		//String jpql = "Select u from Users u where u.username='"+username+"' And u.password='"+password+"'";
		String jpql = "Select u from Users u where u.username=:user And u.password=:pass";
		TypedQuery<Users> tquery = entityManager.createQuery(jpql, Users.class);
		tquery.setParameter("user", username);
		tquery.setParameter("pass", password);
		List<Users> list = tquery.getResultList();
		
		return list.size();
	}


	@Override
	public List<Users> readAllUsers() {
		TypedQuery<Users> query = entityManager.createQuery("Select u From Users u", Users.class);
		List<Users> list = query.getResultList();
		return list;
	}


	@Override
	public int deleteUser(String username) {
		String jpql = "Delete From Users u Where u.username=:user";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("user", username);
		int result = query.executeUpdate();
		return result;
	}


	@Override
	public int createUser(Users user) {
		entityManager.persist(user);
		return 1;
	}


	@Override
	
		public int updateUser(Users user) {
			//String jpql = "Update Users u Set u.firstname='"+user.getFirstname()+"', u.lastname='"+user.getLastname()+"', u.mobilenumber='"+user.getMobilenumber()+"' Where u.username='"+user.getUsername()+"'";
		String jpql = "Update Users u Set u.firstname=:fname, u.lastname=:lname, u.mobilenumber=:mobile Where u.username=:user";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("fname", user.getFirstname());
			query.setParameter("lname", user.getLastname());
			query.setParameter("mobile", user.getMobilenumber());
			query.setParameter("user", user.getUsername());
			int result = query.executeUpdate();
			return result;
		}

	


	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}


	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
	public void rollbackTransaction() {
		entityManager.getTransaction().rollback();
		
	}
	
	/*public int readLogin(String username, String password){
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
		
	}*/

	
	
}


	
	
	
	
	
	
	


                                                                                                                     