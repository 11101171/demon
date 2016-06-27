package com.demon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demon.domain.Article;


/**
 * 文章DAO
 * 
 * @author wangjunbiao
 */
public interface ArticleRepository extends JpaRepository<Article, Long>{
	
	@Query("select a from Article a where a.type=:i and a.showInIndex=1")
	List<Article> findIndexArticle(@Param("i") int i);

}
