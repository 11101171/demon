package com.demon;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demon.util.ParamUtil;

/**   
* <p></p>
* @author ningzong.zeng
*/
public class DemonAdminApplicationFilter implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(DemonAdminApplicationFilter.class);
	
	@Override
	public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse,
			FilterChain paramFilterChain) throws IOException, ServletException {
		// logger.debug("=======doFilter=============");
		if (paramServletRequest instanceof HttpServletRequest) {
			HttpServletRequest request = (HttpServletRequest) paramServletRequest;
			String requestUrl = request.getRequestURL().toString();
			if(!requestUrl.endsWith(".css") && !requestUrl.endsWith(".js") && !requestUrl.endsWith(".woff") && !requestUrl.endsWith(".ico") && !requestUrl.endsWith(".png") ) {
				logger.info("= RequestUrl=>{}, Params=>{}", 
					requestUrl,
					ParamUtil.getBodyParam(request.getParameterMap()));
			}
		}
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
