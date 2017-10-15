package com.yungame.dao;

import java.util.List;

import com.yungame.model.Article;
import com.yungame.model.Users;

public interface ArticleDao {
	
	public Article select(int id);

	public List<Article> selectAll();

	public List<Article> select(Article article);

	public int delet(Article article);

	public int update(Article article);

	public int add(Article article);
}
