package servlet.http;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form") // 폼태그의 액션 ""
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // 인코딩 
		request.setCharacterEncoding("utf-8");
		// 메뉴 받을떄 getparamiter values 사용할것 
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		String[] menu = request.getParameterValues("menu"); //값이 여러개라서 
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h1>정보를 출력합니다...</h1>");
		out.print("<div>당신의 아이디는 "+id+"</div>");
		out.print("<br>");
		out.print("<div>당신의 비밀번호는 "+pwd+"</div>");
		out.print("<br>");
		
		try {
			if(gender.equals("m")) gender ="남자";
			if(gender.equals("f")) gender ="여자";
			out.print("<div>당신의 성별은 "+gender+"</div>");
			out.print("<br>");
			
			
			
		} catch (Exception e) {
		    out.print("<div> 성별을 선택해주세요 !! </div>");
		    out.print("<br>");
		}
		 out.print("<ul>");
		try {
			for(int i =0; i<menu.length; i++) {
				out.print("<li>"+menu[i]+"</li>");
			}
			
			
		} catch (Exception e) {
			out.print("<div> 좋아하는 메뉴가 여기 없나요? </div>");
			  out.print("<br>");
		}
		 out.print("</ul>");
	
		
		out.print("</body></html>");
	out.close();
		
				
				
		
		
		
		
	}

}
