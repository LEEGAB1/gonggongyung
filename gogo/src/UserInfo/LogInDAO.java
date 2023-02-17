package UserInfo;

import java.sql.Connection;

public interface LogInDAO {
   int inputSelect(String id, String pw);
}