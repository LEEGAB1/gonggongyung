package userInfo;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/userinfo/joinbtn")
public class UserInfoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		resp.setHeader("Access-Control-Allow-Headers", "*");
		
		String id = req.getParameter("inputId");
		String name = req.getParameter("inputName");
		
		UserInfoDAO dao = new UserInfoDAOImpl();
		//int resultId = dao.UserInfoSelectId(conn, id);
		//int resultName = dao.UserInfoSelectName(conn, name);
		
		// String json = "{\"inputId\":" + resultId + ",\"inputName\":" + resultName + "}";
		
		String json = "{\"result\":\"ok\"}";
		
		resp.getWriter().println(json);
	}

	

	
}
