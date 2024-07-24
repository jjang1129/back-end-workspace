package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO member = new MemberDAO();
		
		String id = request.getParameter("id"); 
		String name= request.getParameter("name");
		String password = request.getParameter("password");
		
		try {
			member.insertMember(id, password, name);
			response.sendRedirect("index.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("/views/sameid.jsp");
		}
		
		
		
		
		
		
	}

}
