package com.oracle.dao;

import java.util.List;

import com.oracle.jdbc.util.Dao;
import com.oracle.util.PageInfo;
import com.oracle.vo.Book;

public class BookDao {

	public List<Book> getAll(){
		return Dao.query("select * from book order by isbn",Book.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public void getBooksForPage(PageInfo pageInfo) {
	    @SuppressWarnings("rawtypes")
		List list=Dao.query("select * from book order by isbn limit ?,?", Book.class,(pageInfo.getCurrentPage()-1)*pageInfo.getPageSize(),pageInfo.getPageSize());
	    pageInfo.setList(list);
	    Long count=(Long)Dao.queryOne("select count(*) from book")[0];
	    pageInfo.setRecordCount(count.intValue());
	}
	
	public Book getBookById(Integer isbn) {
		return Dao.queryOne("select * from book where isbn=?", Book.class,isbn);
	}
	
	public void save(Book book) {
	    Dao.executeSql("insert into book values(null,?,?)", book.getBookName(),book.getPrice());
	}
	
	public void update(Book book) {
		Dao.executeSql("update book set bookName=?,price=? where isbn=?", book.getBookName(),book.getPrice(),book.getIsbn());;
	}
	
	public void delete(Integer[] isbn) {
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<isbn.length;i++) {
			sb.append("?");
			if(i<isbn.length-1) {
				sb.append(",");
			}
			
		}
		System.out.println("delete from book where isbn in("+sb.toString()+")");
		Dao.execute("delete from book where isbn in("+sb.toString()+")", isbn);
	}
	
	
}
