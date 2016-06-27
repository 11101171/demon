package com.demon.service;

import java.util.List;

import com.demon.domain.TurnImg;


/**   
* 首页业务接口
* 
* @author wangjunbiao
*/
public interface TurnImgService {
	
	/*首页轮播图*/
	List<TurnImg> getTurnImgByType(int i);
	
	
	
	
}
