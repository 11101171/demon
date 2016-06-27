package com.demon.service;

import java.util.List;

import com.demon.domain.MediaType;


/**   
* 媒体业务接口
* 
* @author wangjunbiao
*/
public interface MediaTypeService {
	
	/*获取所有分类*/
	List<MediaType> getAll();
	
	/*首页显示分类*/
	List<MediaType> getIndexMediaType(int i);
	
}
