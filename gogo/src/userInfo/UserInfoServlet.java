package userInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/userinfo/joinbtn")
public class UserInfoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Connection conn = null;
		System.out.println("요청");
		req.setCharacterEncoding("UTF-8");

		UserInfoServiceImpl service = new UserInfoServiceImpl(new UserInfoDAOImpl());
		
//		String body = readBody(req);
		String inputId = req.getParameter("inputId");
		System.out.println("id: " + inputId);
		String inputPw = req.getParameter("inputPw");
		System.out.println("pw: " + inputPw);
		String inputName = req.getParameter("inputName");
		System.out.println("name: " + inputName);
		
		
		int resultId = service.idCheck(inputId);
		int resultName = service.nameCheck(inputName);
		
		String json = "{\"inputId\":" + resultId + ",\"inputName\":" + resultName + "}";
		System.out.println("응답: " + json);
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		pw.flush();
		
		
		if (resultId == 0 && resultName == 0) {
			System.out.println(service.create(inputId, inputPw, inputName));
		}
	}
	
}
