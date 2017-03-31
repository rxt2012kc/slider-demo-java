package com.xindun.server.servlet;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SoapStatisticInit extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() {
		SoapStatistic.getInstance().init();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
	}
	
	public void destroy()
	{
		SoapStatistic.getInstance().destroy();
		
	}
}
