package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int count = 0;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO member = new MemberDAO();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	
		
		
		try {
			 if(member.login(id, password)) {
				
				
				
				// 로그인 정보를 세션이 담기 HttpSession 
				// 1) 세션을 하나 받아온다 
				Member mem = new Member(id,password,member.memberName(id, password));
				
				HttpSession session = request.getSession();
			
				
				// 2) 세션에 바인딩 하기 
				
				
				session.setAttribute("info", mem);
				
				
				response.sendRedirect("index.jsp");
			
				
			 } else {
				 
					
				count++;
				
				
				request.setAttribute("count", count);
				request.getRequestDispatcher("/views/loginFalse.jsp").forward(request, response);
				 //response.sendRedirect("/views/loginFalse.jsp");
				 
				 
				 
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
