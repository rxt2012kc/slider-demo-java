package com.xindun.server.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class LogbackConfigListener implements ServletContextListener {  
    private static final String CONFIG_LOCATION = "logbackConfigLocation";  

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		 //锟斤拷web.xml锟叫硷拷锟斤拷指锟斤拷锟侥硷拷锟斤拷锟斤拷锟街撅拷锟斤拷锟斤拷募锟? 
		System.out.println("................Tomcat Sphere Logging Configurating.................");
        String logbackConfigLocation = sce.getServletContext().getInitParameter(CONFIG_LOCATION);  

        String fn = sce.getServletContext().getRealPath(logbackConfigLocation);  

        try {  

            LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();  

            loggerContext.reset();  

            JoranConfigurator joranConfigurator = new JoranConfigurator();  

            joranConfigurator.setContext(loggerContext);  

            joranConfigurator.doConfigure(fn);  
//            logger.debug("loaded slf4j configure file from {}", fn);
            System.out.println("loaded slf4j configure file from "+ fn);
            StatusPrinter.print(loggerContext);
            } catch (JoranException e) {  
            	e.printStackTrace();
            }  
            
            
        
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	    lc.stop();

	}  

}  

