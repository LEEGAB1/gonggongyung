package UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import com.mysql.cj.conf.ConnectionPropertiesTransform;

import okhttp3.Request;
import zerozerotwo.dbutil.ConnectionProvider;

@WebServlet()
public class LogInDAOImpl extends HttpServlet implements LogInDAO {

   @Override
   public int inputSelect(String id, String pw ) { // 사용자가 입력한 id, pas
	   
      String sql = "SELECT id, password from user_info where id = ? && password = ? ;";
      ResultSet rs = null;
      try (Connection conn = ConnectionProvider.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql); // sql 구문을 실행하는것 PreparedStatement

      ) {
         // ResultSet 결과값 rs = stmt.executeQuery(반환) ()) {

         stmt.setString(1, id); // PreparedStatement을 썼을때 ?를 사용자가 입력한것을 set시켜준다.
         stmt.setString(2, pw);
         rs = stmt.executeQuery(); // db에 있는 결과값에 반환한다 
         while (rs.next()) {
            String userid = rs.getString("id"); // 컬럼값에 있는 "id"를 db에 있는 idd에 넣는다.
            String userpw = rs.getString("password");
            
            // String id = rs.getString(mysql의 컬럼값);

            if (userid.equals(id) && userpw.equals(pw)) {
               System.out.println("성공");
             
               
               return 1;

            } else {
               System.out.println("실패");
               return 0;
            }

         }
      } catch (SQLException e) {
         e.printStackTrace();
         System.out.println("오류 발생");
         return 0;
      } finally {
         if (rs != null) {
            try {
               rs.close();
            } catch (SQLException e) {
               e.printStackTrace();
               System.out.println("오류 발생");
            }
         }
      }
      return 0;
   }

}
