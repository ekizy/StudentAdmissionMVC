package com.example.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnector {

	public Connection con;
	public Statement stmt;
	public ResultSet rs;

	public DBConnector()
	{

	}

	public ArrayList<String> getArray()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/admissiondb","root","");

			ArrayList<String> list = new ArrayList<String>();

			stmt =con.createStatement();
			rs=stmt.executeQuery("Select * from students");

			while(rs.next())
			{
				list.add(rs.getString(2));
			}

			con.close();

			return list;

		}

		catch(Exception e)
		{
			System.out.println(e);
			return new ArrayList<String>();
		}
	}


}