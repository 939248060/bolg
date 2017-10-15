package com.yungame.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.yungame.dao.ArticleDao;
import com.yungame.model.Article;

@Repository
public class ArticleDaoImp extends HibernateDaoSupport implements ArticleDao {

    @Resource
    private SessionFactory sessionFactory;
	 
	public ArticleDaoImp() {
		
	}

	public Article select(int id) {		
		String hql = "from Article where id = ?";	
		List<Article> articleList = (List<Article>) this.getHibernateTemplate().find(hql, id);
		if (articleList != null && articleList.size() > 0) {
			return articleList.get(0);
		}
		return null ;
	}

	public List<Article> selectAll() {
		String hql = "from Article";
		return (List<Article>) this.getHibernateTemplate().find(hql);
	}

	public List<Article> select(Article article) {
		// TODO Auto-generated method stub
		return null;
	}

	public int delet(Article article) {
		this.getHibernateTemplate().delete(article);
		return 0;
	}

	public int update(Article article) {
		this.getHibernateTemplate().update(article);
		return 0;
	}

	public int add(Article article) {
		this.getHibernateTemplate().save(article);
		return 0;
	}

}
