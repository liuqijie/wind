package com.wind.upms.client.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.AuthenticationFilter;

public class UpmsAuthenticationFilter extends AuthenticationFilter {

	public UpmsAuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean onAccessDenied(ServletRequest arg0, ServletResponse arg1)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
