package com.login.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.DBConnection;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String loginId=req.getParameter("loginId");
		String password=req.getParameter("password");
		
		boolean isValidUser=false;
		
		try(Connection con=DBConnection.getConnection()) {
			String sql="Select * from where loginId=? And password=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, loginId);
			stmt.setString(2, password);
			ResultSet rs=stmt.executeQuery();
			
			if(rs.next()) {
				isValidUser=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(isValidUser) {
			RequestDispatcher rd=req.getRequestDispatcher("welcome.jsp");
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("error.jsp");
			rd.forward(req, resp);
		}
	}

}
