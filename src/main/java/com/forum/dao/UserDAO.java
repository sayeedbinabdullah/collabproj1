package com.forum.dao;

import java.util.List;

import com.forum.model.User;

public interface UserDAO {

	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public User getUserById(long userId);
	public List<User> listUsers();
	public  User logincheck(User ud);
	
	
}
