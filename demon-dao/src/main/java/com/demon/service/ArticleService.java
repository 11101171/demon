package com.demon.service;

import java.util.List;

import com.demon.domain.Article;


/**   
* 文章业务接口
* 
* @author wangjunbiao
*/
public interface ArticleService {
	
	/*首页显示文章*/
	List<Article> getIndexArticle(int i);

}
