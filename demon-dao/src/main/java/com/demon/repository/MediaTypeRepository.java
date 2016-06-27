package com.demon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demon.domain.MediaType;

/**
 * 媒体分类DAO
 * 
 * @author wangjunbiao
 */
public interface MediaTypeRepository extends JpaRepository<MediaType, Long> {

	@Query("select m from MediaType m where m.showIndex=:i")
	List<MediaType> findIndexMediaType(@Param("i") int i);

}
