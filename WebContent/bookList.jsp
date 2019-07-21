<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

<script type="text/javascript"  src="js/jquery-1.11.1.js"></script>

<script type="text/javascript">
    $(function(){
    	
    	$("#btn_save").click(function(){
    		window.open("addBook.jsp");
    	});
    	
    	$(".trcontent").hover(function(){
    		$(this).css("background-color","#edefec");
    	},function(){
    		$(this).css("background-color","white");
   
    	});
    	
    	$(".btn_delete").click(function(){
    		var value=$(this).attr("value");
    		if(confirm("你真的要删除吗？")){
    			window.open("deleteBook.do?isbn="+value);
    		}
    	});
    	
    	$("#btn_delete").click(function(){
    		var ck=$("input:checked");
    		if(ck.size()==0){
    			alert("请选择需要删除的图书");
    			return;
    		}
    		
    		if(confirm("你真的要删除吗")){
    			$("#form1").submit();
    		}
    	});
    });

</script>
</head>
<body>

当前在线人数：${count }<br/>
当前登录人数：${fn:length(loginMap)}<br/>
<form  id="form1" action="deleteBook.do" method="post">
     <table border="1" width="90%" align="center">
     <caption>图书列表</caption>
          <tr>
             <td>
                       序号         
             </td>
             <td>
             isbn
             </td>
             <td>
                        书名        
             </td>
             <td>
                        价格          
             </td>
             <td>
                        操作          
             </td>
           </tr>
           
          <c:forEach items="${pageInfo.list}" var="book" varStatus="state">
               
               <tr class="trcontent">
                    <td>${state.count}</td>
                    <td>${book.isbn}</td>
                    <td>${book.bookName}</td>
                    <td>${book.price}</td>
                    <td><a href="editBook.do?isbn=${book.isbn }">编辑</a> <a value="${book.isbn }" class="btn_delete" href="javascript:return void(0)">删除</a><input type="checkbox" name="isbn" value="${book.isbn }"></td>
               </tr>
          
          
          </c:forEach>
          
          
          <tr>
             <td colspan="5">
                  <div>
                                       总记录数：${pageInfo.recordCount }&nbsp;
                                       总页数：${pageInfo.pageCount }&nbsp;
                                       每页记录数：${pageInfo.pageSize }&nbsp;
                                       当前页数：${pageInfo.currentPage }&nbsp;
<%--                                       当前url：${pageInfo.url }&nbsp; --%>
                      <a class="urlaction" href="javascript:return void(0)" value="1">首页</a>
                      
                      <c:if test="${pageInfo.currentPage-1>0 }">
                           <a class="urlaction" href="javascript:return void(0)" value="${pageInfo.currentPage-1 }">上一页</a>
                      </c:if>
                      
                      <c:if test="${pageInfo.currentPage<pageInfo.pageCount }">
                           <a class="urlaction" href="javascript:return void(0)" value="${pageInfo.currentPage+1 }">下一页</a>
                      </c:if>
                          
                      <a class="urlaction" href="javascript:return void(0)" value="${pageInfo.pageCount }">尾页</a>            
                  </div>
             
             </td>
          </tr>
           
       </table>
       
       
       <input type="button" value="添加新图书" id="btn_save">
       <input type="button" value="删除图书" id="btn_delete">
       </form>
       
       <form action="${pageInfo.url}" method="post" id="pageInfoForm">
            <input type="hidden" name="currentPage" id="hd_currentpage">
       </form>
       <script>
           $(function(){
        	   $(".urlaction").click(function(){
        		   $("#hd_currentpage").val($(this).attr("value"));
        		   $("#pageInfoForm").submit();
        	   });
           });
       
       </script>
        
</body>
</html>
   
       
      
             
             
             
             
             
             
        
        
        
             
       
       
       
       
       
       
       
             
             
             
             
             
             
             
             
 