package com.bridgelabz.jdbcprograms;

import java.sql.*;

public class MetaDataProgram {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String qry="select *from bridgelabz.student";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded & Regestered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			DatabaseMetaData dbm=con.getMetaData();
			System.out.println("Driver name"+dbm.getDriverName());
			System.out.println("Driver version"+dbm.getDriverVersion());
			stmt=con.createStatement();
			rs=stmt.executeQuery(qry);
			ResultSetMetaData rsmd=rs.getMetaData();
			System.out.println("Total no of columns "+rsmd.getColumnCount());
			System.out.println("Name of 3rd column "+rsmd.getColumnLabel(3));
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
