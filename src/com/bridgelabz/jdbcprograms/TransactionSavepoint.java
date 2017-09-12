package com.bridgelabz.jdbcprograms;

import java.sql.*;
import java.util.Scanner;

public class TransactionSavepoint {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		Savepoint sp=null;
		String stded="insert into bridgelabz.student values(?,?,?)";
		String stdpr="insert into bridgelabz.studentedu values(?,?,?,?)";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int id=sc.nextInt();
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter branch");
		String branch=sc.next();
		System.out.println("Enter department");
		String dept=sc.next();
		System.out.println("Enter percentage");
		double perc=sc.nextDouble();
		System.out.println("Enter place");
		String place=sc.next();
		sc.close();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded & Regestered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(stded);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, branch);
			pstmt.executeUpdate();
			System.out.println("students details executed");
			sp=con.setSavepoint();
			pstmt1=con.prepareStatement(stdpr);
			pstmt1.setInt(1, id);
			pstmt1.setString(2, dept);
			pstmt1.setDouble(3, perc);
			pstmt1.setString(4, place);
			pstmt1.executeUpdate();
			System.out.println("students education details executed");
			
			con.commit();
		}catch(ClassNotFoundException | SQLException e){
			try{
				con.rollback();
				con.commit();
				System.out.println("Operation roll back");
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}finally{
			if(pstmt!=null){
				try{
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(pstmt1!=null){
				try{
					pstmt1.close();
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
