package GasStation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Service.map.GasStationService;
import Service.map.GasStationServiceImpl;


@WebServlet({"/gogo/gasstation","/gogo/gasstation/*"})
public class GasStationServlet extends HttpServlet {
	private GasStationService gasService;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		gasService = new GasStationServiceImpl(new GasStationDAOImpl());

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// x,y 표값 받아온다 
		//맵핑해서 보낸다
		
		
//		List<Book> list = service.read();
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(list);
//
//		PrintWriter pw = resp.getWriter();
//		pw.println(json);
//		pw.flush();
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String location = req.getParameter("location");
		String storename = req.getParameter("storename");
		System.out.println("location" + location);
		System.out.println("storename" + storename);
		
		
		if(location != null && storename.isEmpty()) {
			List<GasStation> list = gasService.readGas(location);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(list);
			
			PrintWriter pw = resp.getWriter();
			pw.println(json);
			pw.flush();
			
		} else if (location != null && storename != null) {
			List<GasStation> list = gasService.readGasByStorename(location, storename);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(list);
			
			PrintWriter pw = resp.getWriter();
			pw.println(json);
			pw.flush();
		}
	}


	
	private GasStation jsonToGasStation(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, GasStation.class);// 읽고 book class에 맵핑 후 반환
	}
	
	

}
