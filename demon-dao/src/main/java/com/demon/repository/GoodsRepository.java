package com.demon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demon.domain.Goods;

/**
 * 商品DAO
 * 
 * @author wangjunbiao
 */
public interface GoodsRepository extends JpaRepository<Goods, Long> {

	@Query("select g from Goods g where g.showInIndex=:i")
	List<Goods> findIndexGoods(@Param("i") int i);
}
