package com.oracle.dao;

import com.oracle.jdbc.util.Dao;
import com.oracle.vo.User;

public class UserDao {

	public User getUser(String userName,String password) {
		return Dao.queryOne("select * from tb_user where userName=? and password=?",User.class,userName,password);
	}
	
	public void userLoginon(Integer userid) {
		Dao.executeSql("update tb_user set loginCount=loginCount+1,lastDate=now() where userid=?", userid);
	}
	
}
