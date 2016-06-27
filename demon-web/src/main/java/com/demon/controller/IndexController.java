/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.demon.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demon.domain.Article;
import com.demon.domain.Goods;
import com.demon.domain.JobInfo;
import com.demon.domain.MediaType;
import com.demon.domain.TurnImg;
import com.demon.service.ArticleService;
import com.demon.service.GoodsService;
import com.demon.service.JobService;
import com.demon.service.MediaTypeService;
import com.demon.service.TurnImgService;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Resource
	private MediaTypeService mediaTypeService;
	@Resource
	private TurnImgService turnImgService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private ArticleService articleService;
	@Resource
	private JobService jobService;

	@RequestMapping("/index")
	public String index(Map<String, Object> model) {

		// 轮播图
		List<TurnImg> list_trunImg = turnImgService.getTurnImgByType(1);

		// 媒体分类
		List<MediaType> list_mediaType = mediaTypeService.getIndexMediaType(1);

		// 首页显示自媒体
		List<Goods> list_goods = goodsService.getIndexGoods(1);

		// 文章——行业动态
		List<Article> list_industry_dynamics = articleService.getIndexArticle(1);
		// 文章——推广技巧
		List<Article> list_promoted_skill = articleService.getIndexArticle(2);

		// 公司荣誉
		List<TurnImg> list_honor = turnImgService.getTurnImgByType(2);
		
		// 招聘岗位分类
		List<JobInfo> list_jobType = jobService.getJobType();
		// 招聘岗位信息
		List<JobInfo> list_jobInfo = jobService.getJobInfoByTypeId(5);
		

		model.put("trunImg", list_trunImg);
		model.put("mediaType", list_mediaType);
		model.put("goods", list_goods);
		model.put("industryDynamics", list_industry_dynamics);
		model.put("promotedSkill", list_promoted_skill);
		model.put("honor", list_honor);
		model.put("jobType", list_jobType);
		model.put("jobInfo", list_jobInfo);

		return "view/index";
	}

}
