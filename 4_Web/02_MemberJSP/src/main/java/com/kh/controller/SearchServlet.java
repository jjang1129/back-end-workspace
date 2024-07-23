package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO member = new MemberDAO();
		
		
		String id =request.getParameter("id");
		
		Member member1 =member.searchMember(id);
		
		//2. 바인딩 : 멤버 객체
				request.setAttribute("member", member1);
						
		// 3. 네비게이션 : search.jsp
		request.getRequestDispatcher("search.jsp").forward(request, response);
		
		
		
		
		
		
		
	}

}
