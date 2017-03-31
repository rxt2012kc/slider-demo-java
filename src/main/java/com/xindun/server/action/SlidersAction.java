package com.xindun.server.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SlidersAction {
	@Autowired
	private HttpServletRequest req;
	@Autowired
	private HttpServletResponse resp;
	@Autowired
	private HttpSession session;
	private Logger logger = LoggerFactory.getLogger(SlidersAction.class);
	
//	@RequestMapping(value = "slider/list")
//	public Object list(@Param("logs") String logs) {
//		logger.debug(logs);
//		return "/demo/index";
//	}
	@ResponseBody
	@RequestMapping(value = "slider/list", method = RequestMethod.POST)
	public Object get(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String logs = request.getParameter("logs");

		logger.debug(logs);
		return true;
	}
}
