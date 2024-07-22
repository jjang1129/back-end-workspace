package servlet.http;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


@WebServlet("/word") // 어노테이션으로 지정 word로 지정해서 word 서블릿으로 받아서 처리하고 싶을때
public class WordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 // 인코딩 !! - > 한글 처리해야함 
		request.setCharacterEncoding("utf-8"); // 받은거 인코딩 
		response.setContentType("text/html;charset=utf-8"); // 보낼꺼 인코딩 
		System.out.println("word로 요청 받음! ");
		String keyword = request.getParameter("keyword");
		System.out.println(keyword); // syso out은 결국 콘솔에서 나오는것 
		
	PrintWriter out =	response.getWriter(); // 보여지기 위해선 PrinWriter을 사용함  
	out.print("<html><body>");
	out.print("<h1>Client send Data : "+ keyword +"</h1>");
	out.print("</body></html>");
	
	out.close();
		
	
		
		
		
		
	}

}
