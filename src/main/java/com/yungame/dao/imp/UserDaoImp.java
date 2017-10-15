package com.yungame.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.yungame.dao.UserDao;
import com.yungame.model.Users;

@Repository
public class UserDaoImp extends HibernateDaoSupport implements UserDao {
	

      

	public int delet(Users user) {
		this.getHibernateTemplate().delete(user);
		return 0;
	}

	public int update(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int add(Users user) {
		this.getHibernateTemplate().save(user);
		return 0;
	}

	public Users select(int id) {
		String hql = "from Users where id=?";
		System.out.println(hql);
	    List<Users> users = (List<Users>) this.getHibernateTemplate().find(hql, id);
	    if(users !=null && users.size() > 0) {
	    	return users.get(0);
	    }else {
	    	return null;
	    }
	}

	public List<Users> selectAll() {
		String hql = "from Users";		
		return (List<Users>) this.getHibernateTemplate().find(hql);
	}
	
	public List<Users> select(Users user) {
		return (List<Users>)this.getHibernateTemplate().findByExample(user);
	}
	
}
