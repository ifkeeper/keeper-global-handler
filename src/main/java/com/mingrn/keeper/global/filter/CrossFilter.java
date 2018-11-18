package com.mingrn.keeper.global.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域配置类
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 11/11/2018 12:25
 */
public class CrossFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory.getLogger(CrossFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
//		request.setCharacterEncoding("UTF-8");
//		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
		response.setHeader("Access-Control-Expose-Headers", "*");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
