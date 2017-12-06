package com.training.ee.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.ee.ejb.Hello;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/ali")
@RequestScoped
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private Hello hello;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		System.out.println("MyServlet created");
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initMe() {
		System.out.println(this.hello.helloMsg("init"));
	}

	@PreDestroy
	public void destroyMe() {
		System.out.println("destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
	        throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter()
		        .append("Served at: ")
		        .append(request.getContextPath());

		String parameter = request.getParameter("age");
		int parseInt = Integer.parseInt(parameter);

		if (parseInt < 25) {
			System.out.println("Hello : " + this.hello.helloMsg(parameter));
		} else {
			System.out.println("Prev Hello : " + this.hello.prevMsg());
		}

		response.getWriter()
		        .append("\r\n");
		response.getWriter()
		        .append("Training test");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
	        throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request,
		           response);
	}

}
