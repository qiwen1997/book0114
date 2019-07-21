package com.oracle.listener;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionLifeListener
 *
 */
@WebListener
public class MySessionLifeListener implements HttpSessionListener {

	
	
    /**
     * Default constructor. 
     */
    public MySessionLifeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	HttpSession session=se.getSession();
    	System.out.println("Session已经创建，sessionId："+session.getId()+":"+new Date(session.getCreationTime()));
    	
    	System.out.println("当前session超时时间是："+session.getMaxInactiveInterval());
    	
    	//在线人数 +1
    	int count=(Integer) session.getServletContext().getAttribute("count");
    	
    	session.getServletContext().setAttribute("count", count+1);
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	
      System.out.println("session已经销毁 id："+se.getSession().getId()+":"+new Date());
      
      
      
    	System.out.println(se.getSession().getAttribute("user"));
      
    	HttpSession session=se.getSession();
        int count=(Integer) session.getServletContext().getAttribute("count");
    	
    	session.getServletContext().setAttribute("count", count-1);
    	
    	
    }
	
}
