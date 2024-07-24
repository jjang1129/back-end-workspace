package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO member = new MemberDAO();
		Member mem = new Member();
		String id =request.getParameter("id");
		
		try {
			mem = member.searchMember(id);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		if(mem == null) {
			
			response.sendRedirect("views/search_false.jsp");
			
			
		} else {
			request.setAttribute("member", mem);
			
			
			
			request.getRequestDispatcher("views/search_ok.jsp").forward(request, response);

		
			
			
			
		}
			
	
		
		
	}

}
