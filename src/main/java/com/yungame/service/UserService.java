package com.yungame.service;

import java.util.List;

import com.yungame.model.Users;

public interface UserService {
	public Users select(int id);

	public List<Users> selectAll();
	
	public int delet(Users user);

	public int update(Users user);

	public int add(Users user);
	
	public List<Users> select(Users user);
}
