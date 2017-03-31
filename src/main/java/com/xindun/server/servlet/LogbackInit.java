package com.xindun.server.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

/**
 * 初始化logback日志器
 * 
 * @version $Revision: 1.1 $ $Date: 2006/09/20 04:07:03 $
 * 
 */
public class LogbackInit extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init()
	{
		// logback加载配置文件
		String prefix = getServletContext().getRealPath("/");
		String file = getInitParameter("logback");
		// if the logback-init-file is not set, then no point in trying
		System.out.println("................logback start................."
				+ prefix + file);
		if (file != null)
		{
			/*PropertyConfigurator.configure(prefix + file);*/
		    LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();  

		    loggerContext.reset();  
		    JoranConfigurator joranConfigurator = new JoranConfigurator();  

		    joranConfigurator.setContext(loggerContext);  
			try {
				System.out.println("*********Loading Logback Configure***********");
				joranConfigurator.doConfigure( prefix +file);
			} catch (JoranException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
	}
}