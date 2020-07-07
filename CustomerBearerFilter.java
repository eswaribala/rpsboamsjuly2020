package com.boa.customer.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CustomerBearerFilter implements Filter{

	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		log.info("Bearer Filter..............");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//logic
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		String header = httpRequest.getHeader("Authorization");

		if (header == null || !header.startsWith("Bearer")) {
			throw new RuntimeException("No Bearer token found in the request headers");
		}		
		else
			filterChain.doFilter(request, response);

		
	}

}
