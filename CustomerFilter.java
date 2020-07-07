package com.boa.kyc.filters;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ExitCodeGenerator;



public class CustomerFilter implements Filter,ExitCodeGenerator {

	private static Logger logger = LoggerFactory.getLogger(CustomerFilter.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
		logger.info("Customer Filter destroy ......");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		logger.info("Customer Filter init ......");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest httpRequest=(HttpServletRequest) req;

		HttpServletResponse httpResponse=(HttpServletResponse) res;
		
		logger.info("Customer Filter Reading request from ip="+req.getRemoteHost());
		if(req.getRemoteHost().equals("0:0:0:0:0:0:0:1"))
			throw new RuntimeException("Exit Code"+getExitCode()+"Cannot accept request from"+req.getRemoteHost());
		
		filterChain.doFilter(req, res);
	}

	@Override
	public int getExitCode() {
		// TODO Auto-generated method stub
		return new Random().nextInt(10000);
	}

}
