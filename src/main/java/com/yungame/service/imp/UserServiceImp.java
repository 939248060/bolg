package com.yungame.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yungame.dao.UserDao;
import com.yungame.model.Users;
import com.yungame.service.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;
	
	public UserServiceImp() {
		
	}

	public Users select(int id) {	
		return userDao.select(id);
	}

	public int delet(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int add(Users user) {
	
		return userDao.add(user);
	}

	public List<Users> selectAll() {
		
		return userDao.selectAll();
	}

	public List<Users> select(Users user) {
		return userDao.select(user);
	}

}
