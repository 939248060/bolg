package com.yungame.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yungame.dao.ArticleDao;
import com.yungame.model.Article;
import com.yungame.model.Users;
import com.yungame.service.ArticleService;

@Service
public class ArticleServiceImp implements ArticleService {

	@Autowired
	public ArticleDao articleDao;
	
	
	public Article select(int id) {
		
		return articleDao.select(id);
	}

	public List<Article> selectAll() {
		return articleDao.selectAll();
	}

	public List<Article> select(Article article) {
		
		return select(article);
	}

	public int delet(Article article) {
		
		return articleDao.delet(article);
	}

	public int update(Article article) {
		return articleDao.update(article);
	}

	public int add(Article article) {
		return articleDao.add(article);
	}

}
