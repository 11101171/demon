package com.demon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
* <p></p>
* @author ningzong.zeng
*/
@Controller
public class AdminTableController {
	@RequestMapping("/list")
	public String list() {
		return "table/list";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "table/add";
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "table/edit";
	}

}
