package com.oracle.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("服务器已经完成销毁，工程布置在"+sce.getServletContext().getRealPath("/"));
        
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
      System.out.println("服务器已经完成初始化工作，工程布置在"+sce.getServletContext().getRealPath("/"));
      
      sce.getServletContext().setAttribute("count", 0);
      sce.getServletContext().setAttribute("loginMap", MySessionAttributeListener.map);
      
    }
	
}
