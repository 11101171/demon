package com.demon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demon.domain.JobInfo;

/**
 * 招贤纳士DAO
 * 
 * @author wangjunbiao
 */
public interface JobRepository extends JpaRepository<JobInfo, Long> {
	
	@Query("select j from JobInfo j where j.typeId IS NULL")
	List<JobInfo> findJobType();
	
	@Query("select j from JobInfo j where j.typeId =:i")
	List<JobInfo> findJobInfoByTypeId(@Param("i") int i);

}
