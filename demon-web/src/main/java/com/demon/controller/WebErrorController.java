package com.demon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
* <p></p>
* @author ningzong.zeng
*/
@Controller
public class WebErrorController {
	@RequestMapping("/404")
	public String page_404() {
		return "errors/404";
	}

    @RequestMapping("/403")
    public String page_403() {
        return "errors/403";
    }

	@RequestMapping("/500")
	public String page_500() {
		return "errors/500";
	}
}
