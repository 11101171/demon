package com.demon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demon.domain.Goods;
import com.demon.repository.GoodsRepository;
import com.demon.service.GoodsService;

/**
 * @author wangjunbiao
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	public final GoodsRepository goodsRepository;

	@Autowired
	public GoodsServiceImpl(GoodsRepository goodsRepository) {
		this.goodsRepository = goodsRepository;
	}

	@Override
	public List<Goods> getIndexGoods(int i) {
		return this.goodsRepository.findIndexGoods(i);
	}

}
