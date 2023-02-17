package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Service.review.reviewService;
import Service.review.reviewServiceImpl;

@WebServlet({"/gogo/review","/gogo/review/*"})
public class ReviewServlet extends HttpServlet{
	private reviewService reviewservice;
	
	@Override
	public void init(ServletConfig confing) throws ServletException {
		reviewservice = new reviewServiceImpl(new ReviewDAOImpl());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Review> list = reviewservice.readReview();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		pw.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nickname = req.getParameter("nickname");
		String storename = req.getParameter("storename");
		System.out.println("nickname" + nickname);
		System.out.println("storename" + storename);
		
		if(nickname != null) {
			List<Review> list = reviewservice.readReviewBynickname(nickname);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(list);
			
			PrintWriter pw = resp.getWriter();
			pw.println();
			pw.flush();
			
		} else if (storename != null) {
			List<Review> list = reviewservice.readReviewByStorename(storename);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(list);
			
			PrintWriter pw = resp.getWriter();
			pw.println();
			pw.flush();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pk = req.getParameter("pk");
	}
	
	private Review jsonToReview(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, Review.class);
	}

}
