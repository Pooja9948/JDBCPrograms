package com.bridgelabz.jdbcprograms;

import java.io.*;
import java.util.Properties;

public class PropertyReader {

	public static void main(String[] args) {
		Properties props=new Properties();
		FileReader fr=null;
		try{
			fr=new FileReader("/home/bridgeit/Desktop/props.txt");
			props.load(fr);
			String uname=props.getProperty("pooja");
			String password=props.getProperty("nayak");
			System.out.println(uname+" "+password);
			String gender=props.getProperty("ge","key not found");
			System.out.println(gender);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fr!=null){
				try{
					fr.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}

}
