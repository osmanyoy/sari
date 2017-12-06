package com.training.ee.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MyFilter
 */

@WebFilter("/ali")
public class MyFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public MyFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
	        throws IOException, ServletException {

		String parameter = request.getParameter("age");
		int parseInt = Integer.parseInt(parameter);
		if (parseInt < 50) {
			// pass the request along the filter chain
			chain.doFilter(request,
			               response);
		} else {
			response.setCharacterEncoding("UTF-8");
			response.getWriter()
			        .append("Yaþýn çok büyük");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(final FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
