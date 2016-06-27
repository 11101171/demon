package com.demon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demon.domain.JobInfo;
import com.demon.repository.JobRepository;
import com.demon.service.JobService;

/**
 * @author wangjunbiao
 */
@Service
public class JobServiceImpl implements JobService {
	
	public final JobRepository jobRepository;
	
	@Autowired
	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}
	
	@Override
	public List<JobInfo> getJobType() {
		return this.jobRepository.findJobType();
	}

	@Override
	public List<JobInfo> getJobInfoByTypeId(int i) {
		return this.jobRepository.findJobInfoByTypeId(i);
	}

	

}
