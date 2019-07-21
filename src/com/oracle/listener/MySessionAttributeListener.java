package com.oracle.listener;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.oracle.vo.User;

/**
 * Application Lifecycle Listener implementation class MySessionAttributeListener
 *
 */
@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener {

	
	static ConcurrentHashMap<String,HttpSession> map=new ConcurrentHashMap<String,HttpSession>();
	
	
	
    /**
     * Default constructor. 
     */
    public MySessionAttributeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	
    	System.out.println("添加了一个属性："+se.getName()+":"+se.getValue()+":"+se.getSession());
    	
    	if(se.getName().equals("user")) {
    		User user=(User) se.getValue();
    		
    		if(map.containsKey(user.getUserName())) {
    			
    			map.remove(user.getUserName()).invalidate();
    			
    		}
    		
    		map.put(user.getUserName(),se.getSession());
    		System.out.println(user.getUserName()+"--------------已上线");
    	}
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	
    	System.out.println("删除了一个属性："+se.getName()+":"+se.getValue()+":"+se.getSession());
    	
    	if(se.getName().equals("user")) {
    		
    		
    		User user=(User) se.getValue();
    		map.remove(user.getUserName());
    		System.out.println(user.getUserName()+"---------------已下线");
    		
    		
    	}
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	
    	System.out.println("替换了："+se.getName()+":"+se.getValue()+":"+se.getSession());
    	System.out.println("替换后："+se.getSession().getAttribute(se.getName()));
    	
    }
	
}
