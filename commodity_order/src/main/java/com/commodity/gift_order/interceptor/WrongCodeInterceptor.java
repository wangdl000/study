package com.commodity.gift_order.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * @author ou
 */

public class WrongCodeInterceptor implements WebRequestInterceptor {

	@Override
	public void preHandle(WebRequest request) throws Exception {
		System.out.println("WrongCodeInterceptor, preHandle......");
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		System.out.println("WrongCodeInterceptor, postHandle......");
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		System.out.println("WrongCodeInterceptor, afterCompletion......");
	}
}