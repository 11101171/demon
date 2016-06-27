package com.demon.service;

import java.util.List;

import com.demon.domain.Goods;

/**   
* 商品业务接口
* 
* @author wangjunbiao
*/
public interface GoodsService {
	
	/*首页显示商品*/
	List<Goods> getIndexGoods(int i);

}
