package com.kglory.tms.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(CommonFilter.class);
	@Override
	public void destroy() {
		logger.debug("CommonFilter > destroy Call");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		logger.debug("CommonFilter > doFilter Call");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("CommonFilter > init Call");
	}

}
