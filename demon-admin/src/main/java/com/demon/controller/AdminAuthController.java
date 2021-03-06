package com.demon.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demon.access.AdminCookie;
import com.demon.domain.UserPlatform;
import com.demon.service.UserPlatformService;

/**   
* <p></p>
* @author ningzong.zeng
*/
@Controller
@RequestMapping(value="auth")
public class AdminAuthController {
	
	@Autowired
	UserPlatformService userPlatformService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGet(Model model) {
		model.addAttribute("userPlatform", new UserPlatform());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost(HttpSession httpSession, @Valid UserPlatform userPlatform, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "login";
		}
		UserPlatform login = this.userPlatformService.login(userPlatform.getLoginUsername(), userPlatform.getLoginPassword());
		if(login!=null) {
			AdminCookie.setLoginAdmin(httpSession, login);
			return "index";
		}
		model.addAttribute("error", "登录失败");
		return "login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession httpSession, Model model) {
		AdminCookie.removeLoginAdmin(httpSession);
		return loginGet(model);
	}
}
