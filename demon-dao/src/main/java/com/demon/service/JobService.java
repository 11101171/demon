package com.demon.service;

import java.util.List;

import com.demon.domain.JobInfo;

/**   
* 招贤纳士业务接口
* 
* @author wangjunbiao
*/
public interface JobService {
	
	/*岗位分类*/
	List<JobInfo> getJobType();
	
	/*根据分类Id获取招聘岗位信息*/
	List<JobInfo> getJobInfoByTypeId(int i);
	
}
