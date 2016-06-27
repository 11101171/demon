package com.demon;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**   
* <p>全局异常</p>
* @author ningzong.zeng
*/
@ControllerAdvice
public class DemonWapExceptionHandler {
	String DEFAULT_ERROR_VIEW = "error/exception";

    @ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}
    
    
}
