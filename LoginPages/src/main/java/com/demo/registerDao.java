package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerDao {
	private LoginBean loginbean;
	private String dburl="jdbc:mysql://localhost:3306/classicmodel";
	private String uname="root";
	private String pass="123456789";
	private String driver="com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String driver) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection(dburl,uname,pass);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
		
	}
	public String insert(LoginBean loginbean) {
		loadDriver(driver);
		Connection con=getConnection();
		String sql="insert into login (username,password) values (?,?)";
		PreparedStatement prepared;
		try {
			prepared=con.prepareStatement(sql);
			prepared.setString(1,loginbean.getUsername());
			prepared.setString(2,loginbean.getPassword());
			prepared.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Not Entered successfully";
		}
		return "Successfully registered";
	}
}
