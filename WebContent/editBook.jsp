<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    当前在线人数：${count }<br/>
    <form action="updateBook.do" method="post">
    <input type="hidden" name="isbn" value="${book.isbn }">
        <table>
            <tr>
                <td>书名</td>
                <td><input type="text" name="bookName" value="${book.bookName }"></td>
            </tr> 
        
            <tr>
                <td>价格</td>
                <td><input type="text" name="price" value="${book.price }"></td>
            </tr> 
            
            <tr>
                <td colspan="2" > <input type="submit" value="提交"></td>
            
            </tr>
        </table>
    
    </form>
</body>
</html>