package com.lti.service;

import java.util.List;

import com.lti.model.Users;

public interface UserService {
	public boolean checkLogin(String username, String password);
	public List<Users> findAllUsers();
	public boolean removeUser(String username);
	public boolean addUser(Users user);
	public boolean updateUser(Users user);
}
