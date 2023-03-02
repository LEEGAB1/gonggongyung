package GasStation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

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

@WebServlet({ "/gogo/gasstation", "/gogo/gasstation/*" })
public class GasStationServlet extends HttpServlet {
   private GasStationService gasService;

   @Override
   public void init(ServletConfig config) throws ServletException {
      gasService = new GasStationServiceImpl(new GasStationDAOImpl());

   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String storename = req.getParameter("name");
      System.out.println("name" + storename);
      
      if(storename == null) {
         List<String> list = gasService.readGasXY();
         // x,y 표값 받아온다
         // 맵핑해서 보낸다
         
         ObjectMapper mapper = new ObjectMapper();
         String json = mapper.writeValueAsString(list);
         
         PrintWriter pw = resp.getWriter();
         pw.println(json);
         pw.flush();      
         
      } else if (storename != null) {
//         String type = req.getParameter("type");
         String type = "diesel";
         List<GasStation> gaslist = gasService.readGasByStorename(storename);
//         List<GasStation> priceGaslist = gasService.readGasPrice(gaslist.get(0).getRegion(), type);
         String dieselprice = gaslist.get(0).getDiesel();
         String gasolineprice = gaslist.get(0).getGasoline();
         String region = gaslist.get(0).getRegion();
         Map<String, Integer> pricemap = gasService.readGasPrice(region, type);
         int pricenum = pricemap.get(storename);
         
//         for (int i = 0; i < priceGaslist.size(); i++) {
//            if(priceGaslist.get(i).getStorename().equals(gaslist.get(0).getStorename())) {
//               pricenum = (i + 1);
//            }
//         }
         
         String pricejson = "{\"dieselprice\": " + dieselprice + 
                        ", \"gasolineprice\": " + gasolineprice +
                        ", \"region\": \"" +  region +
                        "\" , \"pricenum\": " + pricenum + "}";
         System.out.println(pricejson);
         PrintWriter pw = resp.getWriter();
         pw.println(pricejson);
         pw.flush();   
      }   

   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String region = req.getParameter("guSelect");
      String zone = req.getParameter("dongSelect");
      String storename = req.getParameter("storename");
      System.out.println("region" + region);
      System.out.println("zone" + zone);
      System.out.println("storename" + storename);

      if (region != null && zone == null) {
         List<GasStation> list = gasService.readGasByRegion(region);
         ObjectMapper mapper = new ObjectMapper();
         String json = mapper.writeValueAsString(list);

         PrintWriter pw = resp.getWriter();
         pw.println(json);
         pw.flush();

      } else if (storename != null) {
         List<GasStation> list = gasService.readGasByStorename(storename);
         ObjectMapper mapper = new ObjectMapper();
         String json = mapper.writeValueAsString(list);

         PrintWriter pw = resp.getWriter();
         pw.println(json);
         pw.flush();
      } else if (region != null && zone != null ) {
    	  List<GasStation> list = gasService.readGasByRegionAndZone(region, zone);
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