package com.demon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demon.domain.TurnImg;

/**
 * 媒体分类DAO
 * 
 * @author wangjunbiao
 */
public interface TurnImgRepository extends JpaRepository<TurnImg, Long> {

	@Query("select t from TurnImg t where t.type=:i order by t.showOrder asc")
	List<TurnImg> findTurnImgByType(@Param("i") int i);

}
