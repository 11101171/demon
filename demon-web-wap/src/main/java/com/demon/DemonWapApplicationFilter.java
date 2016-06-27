package com.demon;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**   
* <p></p>
* @author ningzong.zeng
*/
public class DemonWapApplicationFilter implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(DemonWapApplicationFilter.class);
	
	@Override
	public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse,
			FilterChain paramFilterChain) throws IOException, ServletException {
		logger.debug("=======doFilter=============");
		 // 继续执行  
		paramFilterChain.doFilter(paramServletRequest, paramServletResponse);  
	}
	
	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
	
}
