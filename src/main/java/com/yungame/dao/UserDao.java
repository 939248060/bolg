package com.yungame.dao;

import java.util.List;

import com.yungame.model.Users;

public interface UserDao {

	public Users select(int id);
	
	public List<Users> selectAll();
	
	public List<Users> select(Users user);
	
	public int delet(Users user);
	
	public int update(Users user);
	
	public int add(Users user);
}
