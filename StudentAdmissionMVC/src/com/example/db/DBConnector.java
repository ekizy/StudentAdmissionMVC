package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnector {

	public Connection con;
	public Statement stmt;
	public ResultSet rs;

	public DBConnector()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost/admissiondb","root","");
			stmt =con.createStatement();
		}

		catch(Exception e)
		{
			System.out.println(e);
		}

	}



}