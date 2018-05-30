package com.crud.app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDB
 */
@WebServlet("/TestDB")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Test the con
			//Setup
		String user = "ouss";//Change the "user" to your DB connection username
		String pass= "ouss";//Change the "pass" to your DB connection password
		
		String jdbcURl="jdbc:mysql://localhost:3306/customers_DB?useSSL=false"; // change "customers_DB" to your DB name
		String driver ="com.mysql.jdbc.Driver";
		
			// establish the connection
		try {
			PrintWriter out= response.getWriter();
			out.println("Connection to db: "+ jdbcURl);
			Class.forName(driver);
			Connection con= DriverManager.getConnection(jdbcURl, user, pass);
			out.println("Success");
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
