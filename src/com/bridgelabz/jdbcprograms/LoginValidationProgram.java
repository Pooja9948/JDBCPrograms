package com.bridgelabz.jdbcprograms;

import java.sql.*;
import java.util.Scanner;

public class LoginValidationProgram {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name ");
		String name=sc.next();
		System.out.println("Enter password ");		
		String pwd=sc.next();
		sc.close();
		String qry="select * from bridgelabz.user where name=? and password=?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loading and registered...");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1,name);//1 for 1st placeholder
			pstmt.setString(2,pwd);//2 for 1st placeholder
			rs=pstmt.executeQuery();
			if(rs.next()){
				String uname=rs.getString(2);//we can use index as well as column name
				System.out.println("Welcome "+uname);
			}else{
				System.out.println("No name Found !!!");
			}
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try{
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(con!=null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}

}
