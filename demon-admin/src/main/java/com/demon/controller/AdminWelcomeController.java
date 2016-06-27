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

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demon.access.AdminAccess;
import com.demon.access.AdminCookie;
import com.demon.access.AdminLoginer;
import com.demon.domain.UserPlatform;
import com.demon.domain.enums.AdminRole;

@Controller
public class AdminWelcomeController {
	private static final Logger logger = LoggerFactory.getLogger(AdminWelcomeController.class);


	@Value("${application.message:Hello World}")
	private String message = "Hello World";
	
	@RequestMapping("/gettime")
	public @ResponseBody String gettime() {
		return "{\"time\":\""+new Date().getTime()+"\"}";
	}

	@AdminAccess({AdminRole.SUPER_ADMIN, AdminRole.ADMIN})
	@RequestMapping("/")
	public String welcome(AdminLoginer adminLoginValue,Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		logger.info("adminLoginValue=>"+adminLoginValue);
		return "welcome";
	}
	
	@RequestMapping("/set")
	public String welcomea(HttpSession httpSession,Map<String, Object> model) {
		UserPlatform userPlatform = new UserPlatform();
		userPlatform.setId(1L);
		userPlatform.setLoginUsername("hahha");
		userPlatform.setRole(AdminRole.ADMIN);
		AdminCookie.setLoginAdmin(httpSession, userPlatform);
		return "welcome";
	}
	
}
