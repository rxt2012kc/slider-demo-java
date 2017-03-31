package com.xindun.server.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @create: 2012-08-16
 * @note: 	在应用加载时首先加载，
 * 			以保证调用SystemContext.QueSystemContext()
 * 			之前basePath已初始化
 */
public class InitSystemContext extends HttpServlet 
{
	
	private static final long serialVersionUID = 1344189943978568591L;
	private static String basePath = null;
	private Logger log = LoggerFactory.getLogger(InitSystemContext.class);

	public static String getBasePath() {
		if (basePath == null)
		{
			throw new IllegalStateException( "servlet.InitSystemContext not initialized" );
		}
		return basePath;
	}
	
	public void init()
	{
		try {
			super.init();
			setBasepath(getServletContext().getRealPath("/"));
//			log.info("init systemcontxt ok  basepath: " +basePath);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void setBasepath(String s){
		InitSystemContext.basePath = s;
	}
}