package com.lti.service;

import java.util.List;

import com.lti.dao.UserDaoImpl;
import com.lti.model.Users;

public class UserServiceImpl implements UserService {
	UserDaoImpl dao = null;
	public UserServiceImpl(){
		dao = new UserDaoImpl();
	}
	public boolean checkLogin(String username, String password){
		int result = dao.readLogin(username, password);
		if(result ==1)
			return true;
		else
			return false;
	}
	public List<Users> findAllUsers(){
		return dao.readAllUsers();
	}
	public boolean removeUser(String username){
		dao.beginTransaction();
		int result = dao.deleteUser(username);
		if(result ==1){
			dao.commitTransaction();
			return true;
		}
		else
			dao.rollbackTransaction();
			return false;
	}
	public boolean addUser(Users user){
		dao.beginTransaction();
		int result = dao.createUser(user);
		if(result ==1){
			dao.commitTransaction();
			return true;
		}
		else
			dao.rollbackTransaction();
			return false;
	}
	

	public boolean updateUser(Users user) {
		dao.beginTransaction();
		int result = dao.updateUser(user);
		if(result ==1){
			dao.commitTransaction();
			return true;
		}
		else
			dao.rollbackTransaction();
			return false;
	}
}