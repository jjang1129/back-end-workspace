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
import java.util.ArrayList;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;


@WebServlet("/front")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      /*
       *  Container에서 Servlet을 하나로 만들자! FrontController Pattern 
       *  
       * 
       * 소프트웨어 디자인 패턴 중 하나로 웹 애플리케이션 등에서 사용되는 패턴 중 하나 
       * 애플리케이션의 진입점을 중앙집중화하여 요청을 처리하고, 전체적인 흐름을 제어하는 역할
       * 
       * DispatcherServlet은 자바 기반의 웹 애플리케이션에서 
       * FrontControllerPattern을 구현하는데 사용되는 핵심 컴포넌트 
       * SpringFramework와 관련된 개념으로 많이 사용되는데 
       * SpringMVC의 일부로 동작하며 웹 요청을 받아서 적절한 핸들러(컨트롤러)로 라우팅하고,
       * 해당 컨트롤러의 실행 및 응답 생성 등을 관리
       * 
       * 코드 유지 보수성을 위해서 바꿈 !! 그리고 스프링 프레임 워크 구조이기도 함 
       * 
       * */
	int count=0;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청이 어디에서 들어온 요청인지 값을 하나 더 받아야 함 - command 
		String command = request.getParameter("command");
		String path = "/";
		
		try {
			if(command.equals("register")) {
				path = register(request,response);
			}else if (command.equals("search")){
				path = search(request,response);
			}else if(command.equals("login")) {
				path= login(request,response);
			}else if(command.equals("allMember")){
				path=AllMember(request,response);
			}else if (command.equals("deleteMember")) {
				path=DeleteMember(request,response);
			}else if(command.equals("logout")) {
				path=Logout(request, response);
			}
			request.getRequestDispatcher(path).forward(request, response);
		} catch(Exception e) {
			
		}
		
	}
       
	protected String register(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
			
	MemberDAO member = new MemberDAO();
			
			String id = request.getParameter("id"); 
			
			String name= request.getParameter("name");
			
			String password = request.getParameter("password");
			
			member.insertMember(id, password, name);
			
			
			
			return "index.jsp";
					
	}
	
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		MemberDAO member = new MemberDAO();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	
				Cookie c1 = null;
			 if(member.login(id, password)) {
							
				// 로그인 정보를 세션이 담기 HttpSession 
				// 1) 세션을 하나 받아온다 
				Member mem = new Member(id,password,member.memberName(id, password));
				
				HttpSession session = request.getSession();
			
				
				// 2) 세션에 바인딩 하기 
				
				
				session.setAttribute("info", mem);
				
				
				return "index.jsp";
			
				
			 } else {
				 
					
				count++;
				
				
			
			
				
				// count 5이상일때 쿠키 생성 
				// 쿠키가 있으면 로그인 버튼 비활성화 
				// 쿠키가 사라지면 count 다시 0회로 
				
				String asd = null;
				if(count >= 5 ) {
					c1 = new Cookie("ck","ck");
					c1.setMaxAge(20);
					response.addCookie(c1);
					request.setAttribute("ck", c1);
					asd= c1.getValue();			      
				} 
				
				
				if(asd != null ) {
					if(c1 == null) {
						count =0;
					}
					
				}
				
				request.setAttribute("count", count);
				
			
					
			return "/views/login.jsp";
				
				 //response.sendRedirect("/views/loginFalse.jsp");
				 
				 
				 
		
		
		
		
		
	}
			 
	
	}
	
	
	
	
	
	
	protected String search(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
		
		MemberDAO member = new MemberDAO();
		Member mem = new Member();
		String id =request.getParameter("id");
		
		
			mem = member.searchMember(id);
			
			
		
				
		if(mem == null) {
			
			
			
			return "views/search_false.jsp";
			
		} else {
			
			request.setAttribute("member", mem);
			
			
			
		

			return "views/search_ok.jsp";
			
			
			
		}
						
		}
	
	protected String AllMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		MemberDAO member = new MemberDAO();
		
		  
			ArrayList<Member> list =    member.searchAll();
			
			
               request.setAttribute("list", list);
			
			
			
			

			
		return "views/allMember.jsp";
		
		
	}
	protected String DeleteMember(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		
		MemberDAO member = new MemberDAO();
		
		
		  HttpSession session = request.getSession();	  		  
		  Member mem =(Member)session.getAttribute("info");
		  
		
			if (member.deleteMember(mem.getId())) {
				session.invalidate();
				
				
				return "/views/deleteMember.jsp";
			 } 
	
		return null;
		
		
	}
	
	protected String  Logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
			HttpSession session= request.getSession();
					
					Member member=(Member)session.getAttribute("info");
					
					session.invalidate();
					
		
		return "index.jsp";
	}
	
	
	
	
	
}
