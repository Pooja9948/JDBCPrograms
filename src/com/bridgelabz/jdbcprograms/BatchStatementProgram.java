package com.bridgelabz.jdbcprograms;

import java.sql.*;

public class BatchStatementProgram {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String inqry="insert into bridgelabz.student values (9,'rina','eie')";
		String upqry="update bridgelabz.student set name='rini' where id=8";
		String delqry="delete from bridgelabz.student where id=5";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded & Regestered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established with DB server");
			stmt=con.createStatement();
			stmt.addBatch(inqry);
			stmt.addBatch(upqry);
			stmt.addBatch(delqry);
			int arr[]=stmt.executeBatch();//executeBatch() returns int array[]
			for(int i:arr){
				System.out.println(i);
			}
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			if(stmt!=null){
				try{
					stmt.close();
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
