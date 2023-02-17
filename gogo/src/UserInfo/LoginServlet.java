package UserInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/gogo/login/loginbtn")
public class LoginServlet extends HttpServlet{
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 HttpSession sesstion = req.getSession();
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		resp.setHeader("Access-Control-Allow-Headers", "*"); // cors 방지 문구!
		
		req.setCharacterEncoding("UTF-8"); // 타입 설정
		
		LogInDAOImpl dao = new LogInDAOImpl();
		resp.setHeader("Content-Type", "application/json; charset=utf-8");
		
		String inputId = req.getParameter("inputId");
		System.out.println("id: " + inputId);
		String inputPw = req.getParameter("inputPw");
		System.out.println("pw: " + inputPw);
		
		String userInput = dao.inputSelect(inputId, inputPw);
		if(userInput !=  null  ) {
			
			
			sesstion.setAttribute("nickName",userInput );
			
			
		}
		
		
		String json = "{\"userInput\":" + userInput + "}";
		System.out.println("응답: " + json);
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		pw.flush();
	
	}
	
	

}
