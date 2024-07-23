package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.kh.model.dao.MemberDAO;





@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// index.jsp에서 /register로 요청하여 
		// 요청 받은 아이디(id), 비밀번호(pwd) , 이름(name)을 받아 
		
		 // 인코딩 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		
		// 1. (있으면) 폼 값 받아오다 .
		String id =request.getParameter("id");
		String pwd =request.getParameter("pwd");
		String name =request.getParameter("name");
		
		MemberDAO member = new MemberDAO();
		boolean check = member.checkMember(id);
			
		request.setAttribute("name", name);	
		request.setAttribute("check", check);
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		if(!check) {
			member.registerMember(id, pwd, name);
		}
		
		// 2. DAO 호출 - DB 접근 필요시 
		// 결과 페이지 2개방식
//		if(!member.checkMember(id)) {
//		member.registerMember(id, pwd, name);
//		request.setAttribute("name", name);
//		request.getRequestDispatcher("result.jsp").forward(request, response);
//		
//		} else {
//			response.sendRedirect("fail.jsp");
//			
//		}
			
		
		// 바인딩 : 결과 페이지에 서버에서 받은 값 보낼 때 필요한것 
		
		
		
		// 중복여부 판단 후 결과 페이지 2개 - > 회원가입 성공 1 실패 1 
		//               결과 페이지 1개 -> 중복여부에 따라 페이지가 바뀜 
	
		
		// 결과 페이지 지정 - result.jsp
	//	response.sendRedirect("result.jsp");
	// 만약 결과 페이지에 서버에서 받은 값 보여주려면 -> RequestDispatcher forward 방식으로 보내야함 
	
		
	}

}
