package com.demon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demon.access.AdminAccess;
import com.demon.domain.enums.AdminRole;
import com.demon.domain.result.ResultJson;
import com.demon.service.UserPlatformService;

/**   
* <p></p>
* @author ningzong.zeng
*/
@RestController
@RequestMapping("/ajax")
public class AdminAjaxController {
	Logger logger = LoggerFactory.getLogger(AdminAjaxController.class);
	
	@Autowired
	UserPlatformService userPlatformService;
	
	@RequestMapping("/hello")
	public ResultJson thing() {
		Map<String, Object> data = new HashMap<>(); 
		data.put("k1", "v1-----");
		data.put("k2", "v2-----");
		return ResultJson.createSuccess(data);
	}
	

	@AdminAccess({AdminRole.SUPER_ADMIN})
	@RequestMapping(value="/userPlatform/del", method=RequestMethod.POST)
	public ResultJson ajaxUserPlatformDel(@RequestParam(value="ids[]", required=true) List<Long> ids) {
		if(ids.size() != this.userPlatformService.deleteByIdIn(ids) ) return ResultJson.createFailed("删除失败", null);
		return ResultJson.createSuccess();
	}
}
