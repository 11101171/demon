package com.demon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demon.domain.Article;
import com.demon.repository.ArticleRepository;
import com.demon.service.ArticleService;

/**   
* @author wangjunbiao
*/
@Service
public class ArticleServiceImpl implements ArticleService {

	public final ArticleRepository articleRepository;
	
	@Autowired
	public ArticleServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	@Override
	public List<Article> getIndexArticle(int i) {
		return articleRepository.findIndexArticle(i);
	}

}
