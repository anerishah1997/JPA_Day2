package com.lti.service;

import java.util.List;

import com.lti.dao.UserDao;
import com.lti.model.Users;

public class UserService {
	UserDao dao = null;
	public UserService(){
		dao = new UserDao();
	}
	public boolean checkLogin(String username, String password){
		int result = dao.readLogin(username, password);
		if(result ==1)
			return true;
		else
			return false;
	}
	
	public boolean addUser(Users user){
		dao.beginTransaction();
		int result = dao.createUser(user);
		if(result == 1){
			dao.commitTransaction();
			return true;
		}
		else{
			dao.rollbackTransaction();
			return false;
		}
	}
	
	public Users findUserByUsername(String username)
	{
		return dao.readUserByUsername(username);
	}
	public List<Users> findAllUsers(){
		return dao.readAllUsers();
	}
	
	public Users modifyUser(Users user) {
		dao.beginTransaction();
		Users user1 = dao.updateUser(user);
		dao.commitTransaction();
		return user1;
	}
	
	
	public boolean removeUser(String username){
		dao.beginTransaction();
		int result = dao.deleteUser(username);
		if(result ==1){
			dao.commitTransaction();
			return true;
		}
		else{
			dao.rollbackTransaction();
			return false;
		}
			
	}
	
	

	
}