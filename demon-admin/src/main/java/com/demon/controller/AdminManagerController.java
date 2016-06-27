package com.demon.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demon.access.AdminAccess;
import com.demon.domain.UserPlatform;
import com.demon.domain.enums.AdminRole;
import com.demon.service.UserPlatformService;


/**   
* <p></p>
* @author ningzong.zeng
*/
@Controller
@RequestMapping(value="manager")
public class AdminManagerController {
	Logger logger = LoggerFactory.getLogger(AdminManagerController.class);
	int pageSize = 10;
	
	@Autowired
	UserPlatformService userPlatformService;
	
	@AdminAccess({AdminRole.SUPER_ADMIN})
	@RequestMapping(value="/userPlatform/list", method=RequestMethod.GET)
	public String userPlatformList(@RequestParam(value="page",defaultValue="1") int page, Model model) {
		Page<UserPlatform> userPlatforms = userPlatformService.findAll(page - 1, pageSize);
		model.addAttribute("userPlatforms", userPlatforms);
		return "userPlatform/list";
	}
	
	// 创建
	@AdminAccess({AdminRole.SUPER_ADMIN})
	@RequestMapping(value="/userPlatform", method=RequestMethod.GET)
	public String userPlatform(Model model) {
		model.addAttribute("userPlatform", new UserPlatform());
		return "userPlatform/operate";
	}
	
	// 查看
	@AdminAccess({AdminRole.SUPER_ADMIN})
	@RequestMapping(value="/userPlatform/{id}", method=RequestMethod.GET)
	public String userPlatformOperate(@PathVariable String id, Model model) {
		UserPlatform userPlatform = this.userPlatformService.findById(Long.valueOf(id));
		model.addAttribute("userPlatform", userPlatform);
		return "userPlatform/operate";
	}
	
	// 修改或者新增
	@AdminAccess({AdminRole.SUPER_ADMIN})
	@RequestMapping(value="/userPlatform/operate", method=RequestMethod.POST)
	public String userPlatformOperate(@Valid UserPlatform userPlatform, 
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "userPlatform/operate";
		}
		if(userPlatform.getId() == null) {
			if(this.userPlatformService.save(userPlatform) == null){
				return "error/500";
			}
		} else {
			if(this.userPlatformService.update(userPlatform.getId(), userPlatform.getLoginUsername(), userPlatform.getLoginPassword()) != 1) {
				return "error/500";
			}
		}
		return "redirect:/manager/userPlatform/list";
	}
	
}
