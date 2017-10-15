package com.yungame.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.yungame.model.Article;
import com.yungame.service.ArticleService;
@Controller
@Scope("prototype")
public class ArticleAction extends ActionSupport {

	public Article article;
	
	public List<Article> articleList;
	
	@Autowired
	public ArticleService articleService;
	
	public String selectArticle() {
		
		articleList = articleService.selectAll();
		
		return "selectArticle";
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
	
}
