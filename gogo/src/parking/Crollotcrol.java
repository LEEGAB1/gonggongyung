package parking;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import zerozerotwo.dbutil.ConnectionProvider;

public class Crollotcrol {
	
	
	
	
	
	private static Connection conn ;
	public static void main(String[] args) {
		String url = "https://bsparking.bisco.or.kr/03_pkd/pkd03.asp";
		List<String> list = new ArrayList<>();
		try {
			Document doc = Jsoup.connect(url).get();

			Element contentBoxElement = doc.selectFirst(".contentbox");
			
			//한줄 표현
			//String contentBox = contentBoxElement.text().trim();
			
			//자르기
			String str = contentBoxElement.text().trim();
			String[] crol = str.split(" ");
			
			for (int i = 7; i < crol.length; i++) {
				System.out.println(crol[i]);
				
				list.add(crol[i]);
				
			}
			System.out.println(list.size());
//			System.out.println(crol[9]);
//			System.out.println(crol[10]);
//			System.out.println(crol[13]);
//			System.out.println(crol[14]);
//			System.out.println(contentBox);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		 try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CrolDAOImpl dao = new CrolDAOImpl();
		
		dao.crol( conn, list);
	}

	



}