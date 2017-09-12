package com.bridgelabz.jdbcprograms;

import java.sql.*;
import java.util.Scanner;

public class SelectPerticularRecord {

	public static void main(String[] args){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id ?");
		int id=sc.nextInt();
		sc.close();
		String qry="select * from bridgelabz.student where id=?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loading and registered...");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				String name=rs.getString(2);//we can use index as well as column name
				String branch=rs.getString("branch");
				System.out.println(name+" "+branch);
			}else{
				System.out.println("No Record Found !!!");
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
