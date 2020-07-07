package com.boa.kyc.configurations;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boa.kyc.filters.CustomerFilter;

@Configuration
public class CustomerFilterConfiguration {

	
	@Bean
	public FilterRegistrationBean getCustomerFilter()
	{
		FilterRegistrationBean filterBean =new FilterRegistrationBean();
		CustomerFilter customerFilter=new CustomerFilter();
		filterBean.setFilter(customerFilter);
		filterBean.setOrder(1);
		filterBean.addUrlPatterns("/getallcustomers/*");
		return filterBean;
	}
	
}
