package com.oracle.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageInfo {

	List<Object> list=new ArrayList<Object>();
	
	int currentPage=1;
	int recordCount=0;
	
	int pageSize=10;
	
	int pageCount=0;
	
	String url=null;

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public int getPageCount() {
		pageCount=this.recordCount%this.pageSize==0?this.recordCount/this.pageSize:this.recordCount/this.pageSize+1;
		return pageCount;
	}
	
	public PageInfo(HttpServletRequest request) {
		
		if(request.getParameter("currentPage")!=null) {
			this.currentPage=Integer.valueOf(request.getParameter("currentPage"));
		}
		this.url=request.getRequestURL().toString();
		request.setAttribute("pageInfo", this);
	}
	
	
}
